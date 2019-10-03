package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersService extends DatabaseService {
    public List<Member> getAllMembers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM members ")
                        .mapToBean(Member.class)
                        .list()
        );
    }
//
//    public void addBook(Library library) {
//        jdbi.useHandle(handle ->
//                handle.createUpdate("INSERT INTO library (bookTitle, bookAuthor, ISBN) VALUES (:bookTitle, :bookAuthor, :ISBN)")
//                        .bind("bookTitle", library.getBookTitle())
//                        .bind("bookAuthor", library.getBookAuthor())
//                        .bind("ISBN", library.getISBN())
//                        .execute()
//        );
//    }
//
//    public void deleteBook(int idLibrary) {
//        jdbi.useHandle(handle ->
//                handle.createUpdate("DELETE FROM library WHERE idLibrary = :idLibrary")
//                        .bind("idLibrary", idLibrary)
//                        .execute()
//        );
//    }

}
