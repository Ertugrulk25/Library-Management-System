package com.ert.library_management_system.domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Student {

private Long id;

private String name;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Books> borrowedBooks = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, List<Books> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Books> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}


