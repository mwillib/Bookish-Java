package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Library;

import java.util.List;

public class BookPageModel {
    private List<Book> specificBooks;

    public List<Book> getSpecificBooks() {
        return specificBooks;
    }

    public void setSpecificBooks(List<Book> specificBooks) {
        this.specificBooks = specificBooks;
    }
}
