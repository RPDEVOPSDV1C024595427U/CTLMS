package com.ctlms;

public class Book {
    private int bookID;
    private String bookISBN;
    private String bookTitle;
    private int bookQuantity;
    private String bookShelf;
    private String bookAuthor;

    public Book(int bookID, String bookISBN, String bookTitle, int bookQuantity, String bookShelf) {
        this.bookID = bookID;
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookQuantity = bookQuantity;
        this.bookShelf = bookShelf;
    }

    public Book(int bookID, String bookISBN, String bookTitle, int bookQuantity, String bookShelf, String bookAuthor) {
        this.bookID = bookID;
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookQuantity = bookQuantity;
        this.bookShelf = bookShelf;
        this.bookAuthor = bookAuthor;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public String getBookShelf() {
        return bookShelf;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }
}
