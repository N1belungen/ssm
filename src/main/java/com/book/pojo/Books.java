package com.book.pojo;

public class Books {

    private int bookID;
    private String bookName;
    private int bookCounts;
    private int bookBorrow;
    private String detail;

    public Books() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public int getBookBorrow() {
        return bookBorrow;
    }

    public void setBookBorrow(int bookBorrow) {
        this.bookBorrow = bookBorrow;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", bookBorrow=" + bookBorrow +
                ", detail='" + detail + '\'' +
                '}';
    }
}
