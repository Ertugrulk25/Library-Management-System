package com.ert.library_management_system.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
@Id
private Long id;
@Column
private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<Books> books = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, List<Books> books) {
        this.id = id;
        this.name = name;
        this.books = books;
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

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}


