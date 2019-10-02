package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService extends DatabaseService {

    public List<Library> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM library")
                        .mapToBean(Library.class)
                        .list()
        );
    }

    public void addBook(Library library) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO library (bookTitle, bookAuthor, ISBN) VALUES (:bookTitle, :bookAuthor, :ISBN)")
                        .bind("bookTitle", library.getBookTitle())
                        .bind("bookAuthor", library.getBookAuthor())
                        .bind("ISBN", library.getISBN())
                        .execute()
        );
    }

    public void deleteBook(int idLibrary) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM library WHERE id = :id")
                        .bind("id", idLibrary)
                        .execute()
        );
    }
}