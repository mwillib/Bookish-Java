package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;

import java.util.List;

public class BookPageModel {
    private List<Book> specificBooks;
    private String title;

    public List<Book> getSpecificBooks() {
        return specificBooks;
    }

    public void setSpecificBooks(List<Book> specificBooks) {
        this.specificBooks = specificBooks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
