package com.ert.library_management_system.domain;

import javax.persistence.*;

@Entity
public class Books {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;
@Column(nullable = false)
private String bookName;
@Column(nullable = false)
private String author;
@Column(nullable = false)//henüz ödünç alınmadığı için başlangıç değeri false
private boolean borrow = false;

    public Books() {
    }

    public Books(Long id, String bookName, String author, boolean borrow) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.borrow = borrow;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", borrow=" + borrow +
                '}';
    }
}
