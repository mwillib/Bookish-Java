package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Library;

import java.util.List;

public class LibraryPageModel {
    private List<Library> books;

    public List<Library> getBooks() {
        return books;
    }

    public void setBooks(List<Library> books) {
        this.books = books;
    }

}
