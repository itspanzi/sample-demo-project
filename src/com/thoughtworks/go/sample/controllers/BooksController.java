package com.thoughtworks.go.sample.controllers;

import com.thoughtworks.go.sample.models.Book;
import com.thoughtworks.go.sample.persistance.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BooksController {

    private BooksRepository booksRepository;

    @Autowired
    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView allBooks(HttpServletRequest request) {
        Map model = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            model.put("message", session.getAttribute("flash"));
            session.removeAttribute("flash");
        }
        model.put("books", booksRepository.allBooks());
        return new ModelAndView("books/index", model);
    }

    @RequestMapping(value = "/books/new", method = RequestMethod.GET)
    public ModelAndView newBook() {
        return new ModelAndView("books/new", new HashMap());
    }

    @RequestMapping(value = "/books/create", method = RequestMethod.POST)
    public ModelAndView createBook(@RequestParam("isbn") String isbn,
                                   @RequestParam("name") String name,
                                   @RequestParam("author") String author,
                                   @RequestParam("publisher") String publisher,
                                   HttpServletRequest request) {
        booksRepository.save(new Book(isbn, name, author, publisher));
        request.getSession(true).setAttribute("flash", "Book created successfully");
        return new ModelAndView(new RedirectView("/books", true));
    }
}
