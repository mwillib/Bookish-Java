package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Library;
import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.BookPageModel;
import org.softwire.training.bookish.models.page.LibraryPageModel;
import org.softwire.training.bookish.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping("")
    ModelAndView library() {

        List<Library> allBooks = libraryService.getAllBooks();

        LibraryPageModel libraryPageModel = new LibraryPageModel();
        libraryPageModel.setBooks(allBooks);

        return new ModelAndView("library", "model", libraryPageModel);
    }

    @RequestMapping("/add-book")
    RedirectView addBook(@ModelAttribute Library library) {

        libraryService.addBook(library);

        return new RedirectView("/library");
    }
//
    @RequestMapping("/delete-book")
    RedirectView deleteBook(@RequestParam int idLibrary) {

        libraryService.deleteBook(idLibrary);

        return new RedirectView("/library");
    }

    @RequestMapping("/sorted-by-title")
    ModelAndView sortTitle() {

        List<Library> allBooks = libraryService.sortByTitle();

        LibraryPageModel libraryPageModel = new LibraryPageModel();
        libraryPageModel.setBooks(allBooks);

        return new ModelAndView("library", "model", libraryPageModel);
    }

    @RequestMapping("/sorted-by-author")
    ModelAndView sortAuthor() {

        List<Library> allBooks = libraryService.sortByAuthor();

        LibraryPageModel libraryPageModel = new LibraryPageModel();
        libraryPageModel.setBooks(allBooks);

        return new ModelAndView("library", "model", libraryPageModel);
    }

    @RequestMapping("/search")
    ModelAndView search(@RequestParam(defaultValue = "") String search){
        List<Library> books = libraryService.searchBooks(search);

        LibraryPageModel libraryPageModel = new LibraryPageModel();
        libraryPageModel.setBooks(books);

        return new ModelAndView("library", "model", libraryPageModel);
    }

    @RequestMapping("/book")
    ModelAndView selectBook(@RequestParam int idLibrary) {

        List<Book> books = libraryService.selectBook(idLibrary);
        String title = libraryService.specificTitle(idLibrary);

        BookPageModel bookPageModel = new BookPageModel();
        bookPageModel.setSpecificBooks(books);

        bookPageModel.setTitle(title);

        return new ModelAndView("book", "model", bookPageModel);
    }
}
