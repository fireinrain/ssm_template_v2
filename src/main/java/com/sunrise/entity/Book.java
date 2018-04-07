package com.sunrise.entity;

public class Book {
    private Long bookId;
    private String name;
    private Integer number;

    public Book(Long bookId, String name, Integer number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
