package com.ert.library_management_system.controller;

import com.ert.library_management_system.config.HibernateUtils;
import com.ert.library_management_system.repository.BookRepository;
import com.ert.library_management_system.repository.StudentRepository;
import com.ert.library_management_system.service.BookService;
import com.ert.library_management_system.service.StudentService;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayLibraryManagementSystem() {

        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository );

        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService();

        int choice;
        do {
            System.out.println("=================== LİBRARY MANAGEMENT SYSTEM ===============");
            System.out.println("1. Book Operations ");
            System.out.println("2. Student Operation ");
            System.out.println("3. Borrow Operations ");
            System.out.println("0. EXIT ");
            System.out.println("Enter your choice ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    //book
                    displayBookOperationsMenu(bookService);
                    break;
                case 2:
                    //student
                    break;
                case 3:
                    //borrow
                    break;
                case 0:
                    //exit
                    System.out.println("Good Byee...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalide choice, Please try again !!!");
                    break;
            }
        }while (choice!=0);
    }

    private static void displayBookOperationsMenu(BookService bookService){
        boolean exit = false;
        while (!exit){
            System.out.println("==== Book Operations ====");
            System.out.println("1. Add a new Book");
            System.out.println("2. Find Book By ID");
            System.out.println("3. Delete Book By ID");
            System.out.println("4. Find All Books");
            System.out.println("5. Update Book By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1 :
                    bookService.saveBook();
                    break;
                case 2:
                    System.out.println("Enter the book ID: ");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();

                    bookService.findBookById(bookId);
                    break;
                case 3:
                    System.out.println("Enter the Book ID: ");
                    Long deleteWithId = scanner.nextLong();
                    scanner.nextLine();

                    bookService.deleteById(deleteWithId);
                    break;
                case 4:
                    bookService.findAllBooks();
                    break;
                case 5:
                    System.out.println("Enter the book ID: ");
                    Long updateBookId= scanner.nextLong();
                    scanner.nextLine();

                    bookService.updateById(updateBookId);
                    break;
                case 0:
                    break;
                default:
                    break;

            }


        }

    }
}
