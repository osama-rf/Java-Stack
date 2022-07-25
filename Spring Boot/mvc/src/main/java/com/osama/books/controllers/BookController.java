package com.osama.books.controllers;

import com.osama.books.models.Book;
import com.osama.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String hi(){
        return "show.jsp";
    }


    @GetMapping("/api/books/{id}")
    public String showBook(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}
