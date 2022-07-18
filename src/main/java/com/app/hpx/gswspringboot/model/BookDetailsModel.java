package com.app.hpx.gswspringboot.model;

public class    BookDetailsModel {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int yearOfPublishing;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public String toString() {
        return "BookDetailsModel [bookAuthor=" + bookAuthor + ", bookId=" + bookId + ", bookName=" + bookName
                + ", yearofPublishing=" + yearOfPublishing + "]";
    }
}