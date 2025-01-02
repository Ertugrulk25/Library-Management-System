package com.ert.library_management_system.controller;

import com.ert.library_management_system.config.HibernateUtils;
import com.ert.library_management_system.repository.BookRepository;
import com.ert.library_management_system.repository.StudentRepository;
import com.ert.library_management_system.service.BookService;
import com.ert.library_management_system.service.BorrowService;
import com.ert.library_management_system.service.StudentService;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayLibraryManagementSystem() {

        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);

        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        int choice;
        do {
            System.out.println("=================== LİBRARY MANAGEMENT SYSTEM ===============");
            System.out.println("1. Book Operations ");
            System.out.println("2. Student Operation ");
            System.out.println("3. Borrow Operation ");
            System.out.println("0. EXIT ");
            System.out.println("Enter your choice ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //book
                    displayBookOperationsMenu(bookService);
                    break;
                case 2:
                    //student
                    displayStudentOperationsMenu(studentService);
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
        } while (choice != 0);
    }

    private static void displayBookOperationsMenu(BookService bookService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Book Operations ====");
            System.out.println("1. Add a new Book");
            System.out.println("2. Find Book By ID");
            System.out.println("3. Delete Book By ID");
            System.out.println("4. Find All Books");
            System.out.println("5. BORROW A BOOK ");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
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
                    Long updateBookId = scanner.nextLong();
                    scanner.nextLine();

                    bookService.updateById(updateBookId);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Return to main menu...");
                    break;
                default:
                    System.out.println("Invalid chocie . Please try again...");
                    break;

            }


        }

    }

    private static void displayStudentOperationsMenu(StudentService studentService) {

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Student Operations ====");
            System.out.println("1. Add a new Student");
            System.out.println("2. Delete Student By ID");
            System.out.println("3. Update Student By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    studentService.saveStudent();
                    break;
                case 2:
                    System.out.println("Enter the student ID: ");
                    Long deleteStudentWithId = scanner.nextLong();
                    scanner.nextLine();

                    studentService.deleteById(deleteStudentWithId);
                    break;
               case 3:
                   System.out.println("Enter the student ID: ");
                   Long updateStudentId = scanner.nextLong();
                   scanner.nextLine();

                  studentService.updateById(updateStudentId);
                   break;
                case 0:
                    exit = true;
                    System.out.println("Return to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice . Please try again...");
                    break;

            }
        }
        }




        }
