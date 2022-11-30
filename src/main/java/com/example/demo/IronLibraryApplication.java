package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Issue;
import com.example.demo.models.Student;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.IssueRepository;
import com.example.demo.repositories.StudentRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class IronLibraryApplication implements CommandLineRunner {
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	IssueRepository issueRepository;

	public static void main(String[] args) {
		SpringApplication.run(IronLibraryApplication.class, args);
	}

	public static void chooseMenu(AuthorRepository authorRepository, BookRepository bookRepository, StudentRepository studentRepository, IssueRepository issueRepository) {
		Scanner sc = new Scanner(System.in);

		int options = 1;
		while (options != 0) {
			//aparece le menu de opciones a escojer
			System.out.println(
					"Choose an option\n" +
							"1 Add a book\n" +
							"2 Search book by title\n" +
							"3 Search book by category\n" +
							"4 Search book by author\n" +
							"5 List all books along with author\n" +
							"6 Issue book to student\n" +
							"7 List books by usn\n" +
							"8 Exit");
			options = sc.nextInt();

			switch (options) {
				case 1: {
					//Add a book
					addBook(authorRepository, bookRepository);
					break;
				}
				case 2: {
					//Search book by title
					searchBookByTitle(bookRepository);
					break;
				}
				case 3: {
					//Search book by category
					searchBookByCategory(bookRepository);
					break;
				}
				case 4: {
					//Search book by author
					searchBookByAuthor(bookRepository);
					break;
				}
				case 5: {
					//List all books along with author
					listBooksWithAuthor(bookRepository);
					break;
				}
				case 6: {
					//Issue book to student
					issueBookStudent(studentRepository, bookRepository, issueRepository);
					break;
				}
				case 7: {
					//List books by usn
					listBooksUsn(studentRepository, bookRepository, issueRepository);
					break;
				}
				case 8: {
					//Exit
					System.out.println("Se procede a salir del programa");
					sc.close();
					break;
				}
				default:
					//Error
					System.out.println("Choose a correct option between 1 and 8");
					break;
			}
		}
	}

	public static void addBook(AuthorRepository authorRepository, BookRepository bookRepository) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please introduce a isbn: ");
		String isbnBook = sc.next();
		System.out.println("Please introduce a title: ");
		String titleBook = sc.next();
		System.out.println("Please introduce a category: ");
		String categoryBook = sc.next();
		System.out.println("Please introduce the name of the author: ");
		String nameAuthor = sc.next();
		System.out.println("Please introduce the mail of the author: ");
		String mailAuthor = sc.next();
		System.out.println("Please introduce the number of books: ");
		Integer numberCopiesBook = Integer.valueOf(sc.next());

		//create new author
		Author author = new Author(nameAuthor, mailAuthor);
		//guardar objeto autor al repositorio
		authorRepository.save(author);
		//create new book
		Book book = new Book(isbnBook, titleBook, categoryBook, numberCopiesBook);
		//guardar objeto book al repositorio
		bookRepository.save(book);

		sc.nextLine();
	}

	public static Book searchBookByTitle(BookRepository bookRepository) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce the title of the book you want: ");
		String titleBook = sc.next();
		if (bookRepository.findByTitle(titleBook).isPresent()) {
			return bookRepository.findByTitle(titleBook).get();
		}
		System.err.println("Title not found");
		return null;
	}

	public static List<Book> searchBookByCategory(BookRepository bookRepository) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce the category of the book you want: ");
		String categoryBook = sc.next();
		List<Book> booksByCategory = bookRepository.findByCategory(categoryBook);
		if (booksByCategory.isEmpty()) {
			System.err.println("No books in this category ");
		}
		return booksByCategory;
	}

	public static List<Book> searchBookByAuthor(BookRepository bookRepository) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce the name of the author you want: ");
		String authorName = sc.next();
		List<Book> booksByAuthor = bookRepository.findByAuthorName(authorName);
		if (booksByAuthor.isEmpty()) {
			System.err.println("No books from this author ");
		}
		return booksByAuthor;
	}

	public static List<Book> listBooksWithAuthor(BookRepository bookRepository) {
		System.out.println("Here are all the books available in our library: ");
		return bookRepository.findAll();
	}

	public static void issueBookStudent(StudentRepository studentRepository, BookRepository bookRepository, IssueRepository issueRepository) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce the USN of the student: ");
		String studentUsn = sc.next();
		System.out.println("Introduce the name of the student: ");
		String studentName = sc.next();
		Student student = studentRepository.save(new Student(studentUsn, studentName));
		System.out.println("Introduce the ISBN of the book: ");
		String bookIssueISBN = sc.next();
		if (bookRepository.findByIsbn(bookIssueISBN).isPresent()) {
			Book book = bookRepository.findByIsbn(bookIssueISBN).get();
			book.setQuantity(book.getQuantity() - 1);
			bookRepository.save(book);
			Issue issue = new Issue(LocalDate.now().toString(), LocalDate.now().plusDays(7).toString(), student, book);
			issueRepository.save(issue);
		}
		System.err.println("ISBN not available");
	}


	public static List<Issue> listBooksUsn(StudentRepository studentRepository, BookRepository bookRepository, IssueRepository issueRepository) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce the USN of the student: ");
		String studentUsn = sc.next();
		if (studentRepository.findByUsn(studentUsn).isPresent()) {
			return studentRepository.findByUsn(studentUsn).get().getIssueList();
		}
		System.err.println("USN not found");
		return null;
	}

	@Override
	public void run(String... args) throws Exception {

		chooseMenu(authorRepository, bookRepository, studentRepository, issueRepository);

	}
}
