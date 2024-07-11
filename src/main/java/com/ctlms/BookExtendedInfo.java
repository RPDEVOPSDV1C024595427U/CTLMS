package com.ctlms;

public class BookExtendedInfo {
    private String bookISBN;
    private String bookSummary;
    private String bookPublisher;
    private int bookYear;
    private String imagePath;

    public BookExtendedInfo(String bookISBN, String bookSummary, String bookPublisher, int bookYear, String imagePath) {
        this.bookISBN = bookISBN;
        this.bookSummary = bookSummary;
        this.bookPublisher = bookPublisher;
        this.bookYear = bookYear;
        this.imagePath = imagePath;
    }

	public String getBookISBN() {
        return bookISBN;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public int getBookYear() {
        return bookYear;
    }

    public String getImagePath() {
        return imagePath;
    }
}
