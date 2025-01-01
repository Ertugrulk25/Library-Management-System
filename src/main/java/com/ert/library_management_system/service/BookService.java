package com.ert.library_management_system.service;

import com.ert.library_management_system.domain.Books;
import com.ert.library_management_system.domain.Student;
import com.ert.library_management_system.exception.BookNotFoundException;
import com.ert.library_management_system.repository.BookRepository;
import com.ert.library_management_system.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class BookService {
  private Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public void saveBook() {
//book objesi oluştur.
        Books books = new Books();
        System.out.println("Enter the Book name: ");
        String bookName = scanner.nextLine();
       //girilen kitap ismi set edilir.
        books.setBookName(bookName);
        System.out.println("Enter the Author name: ");
        String authorName = scanner.nextLine();
        books.setAuthor(authorName);
        bookRepository.save(books);

        System.out.println("Book saved successfully . Book ID:"+ books.getId());
    }

    public Books findBookById(Long bookId) {

        try {
            Books foundBook = bookRepository.findById(bookId);

            if (foundBook!=null) {
                System.out.println(foundBook);

                return foundBook;
            }else {//kendimiz exception oluşturduk
              throw new BookNotFoundException("Book not foun by ID: ");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }

    public void deleteById(Long deleteWithId) {
   Books deleteBook = findBookById(deleteWithId);

   if (deleteBook != null){

       bookRepository.delete(deleteBook);
       System.out.println("Delete operation is successfully");
   }else {
       System.out.println("Delete operation is failed ");

   }


    }

    public void findAllBooks() {

        List<Books> books = bookRepository.findAll();
        if (books.isEmpty()){
            System.out.println("Books list is EMPTY ");
        }else {
            System.out.println("ALL BOOKS ");
            for (Books books1 : books){
                System.out.println(books1);
            }
            System.out.println("All BOOKS ");
        }
    }

    public void updateById(Long updateBookId) {
        Books books = findBookById(updateBookId);
        Student student = new Student();


        System.out.println("Enter book situation");
        boolean book = scanner.nextBoolean();
        books.setBorrow(book);

        System.out.println("Enter student ID: ");
        Long id = scanner.nextLong();
        student.setId(id);

        books.setStudent(student);

        bookRepository.update(books);

    //DEVAM ETTTTTTTTTTTTTTTTTT

    }
}



