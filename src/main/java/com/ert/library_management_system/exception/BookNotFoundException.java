package com.ert.library_management_system.exception;

public class BookNotFoundException extends RuntimeException {
public BookNotFoundException(String massage){
    super(massage);
}
}
