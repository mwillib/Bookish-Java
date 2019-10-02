package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Library;

import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost:3306";
        String database = "bookish";
        String user = "root";
        String password = "Csakteszt11!";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

//        jdbcMethod(connectionString);
//        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);
        String query = "SELECT * FROM library";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            String title = rs.getString("bookTitle");
            String author = rs.getString("bookAuthor");
            System.out.println(title + " from " + author);
        }


    }

    private static void jdbiMethod(String connectionString) {

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);

        List<Library> libraryList = jdbi.withHandle(handle -> {
            List<Library> library =
                    handle.createQuery("SELECT * FROM library ORDER BY bookTitle")
                            .mapToBean(Library.class)
                            .list();

            return library;
        });

        for(Library library : libraryList) {
            System.out.println(library.getBookTitle() + " from " + library.getBookAuthor());
        }

    }
}
