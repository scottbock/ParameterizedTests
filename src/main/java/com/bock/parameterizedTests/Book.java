package com.bock.parameterizedTests;

public class Book {

    private String title;

    public static Book fromTitle(String title){
        Book book = new Book();
        book.setTitle(title);

        return book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
