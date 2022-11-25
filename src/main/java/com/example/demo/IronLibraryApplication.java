package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class IronLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(IronLibraryApplication.class, args);

		chooseMenu();

	}

		public static void chooseMenu(){
			Scanner sc = new Scanner(System.in);

			int options = 1;
			while (options != 0){
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

				switch (options){
					case 1:{
						//Add a book
						break;
					}
					case 2:{
						//Search book by title
						break;
					}
					case 3:{
						//Search book by category
						break;
					}
					case 4:{
						//Search book by author
						break;
					}
					case 5:{
						//List all books along with author
						break;
					}
					case 6:{
						//Issue book to student
						break;
					}
					case 7:{
						//List books by usn
						break;
					}
					case 8:{
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

}
