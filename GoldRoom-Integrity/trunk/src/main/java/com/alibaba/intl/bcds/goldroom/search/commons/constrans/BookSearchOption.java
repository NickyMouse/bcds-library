package com.alibaba.intl.bcds.goldroom.search.commons.constrans;

/**
 * advanced search book option
 *
 * @author Giraffe
 */
public class BookSearchOption {

    /** book name */
    String bookName;

    /** the publisher of the book */
    String publisher;

    /** the ISBN of the book */
    String isbn;

    /** the description of the book */
    String description;

    /** the time of the book on shelf */
    String daysBefore;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDaysBefore() {
        return daysBefore;
    }

    public void setDaysBefore(String daysBefore) {
        this.daysBefore = daysBefore;
    }

}
