package com.example.bookClub.controllers;

import com.example.bookClub.models.Book;
import com.example.bookClub.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // Dashboard
    @GetMapping("/book")
    public String dashboard(HttpSession session, Model model){
        if (session.getAttribute("user_id") == null){
            return "redirect/";
        } else {
            List<Book> books = bookService.allBook();
            model.addAttribute("books", books);
            return "home.jsp";
        }
    }

    // Add new Book by specific user

    // 1 Validation if user in session.
    @GetMapping(value = "/book/add")
    public String addBook(@ModelAttribute("book") Book book, HttpSession session){
        if (session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        return "new.jsp";
    }

    // 2 Add new Book
    @PostMapping("/book/add")
    public String newBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session){
        Optional<Long> userId = Optional.of((Long) session.getAttribute("user_id"));
        if (!userId.isPresent()){
            return "redirect:/";
        }
        if (result.hasErrors()){
            return "new.jsp";
        }else {
            bookService.createBook(book,userId.get());
            return "redirect:/book";
        }
    }

    // Show Book
    @GetMapping("book/{id}")
    public String showBook(@PathVariable("id") Long id, Model model, HttpSession session){
        if (session.getAttribute("user_id") == null){
            return "redirect:/";
        } else {
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "show.jsp";
        }
    }

    // Edit Book

    // 1 Edit Book
    @GetMapping("/book/{id}/edit")
    public String editBook(@PathVariable("id") Long id, HttpSession session, Model model){
        Book book = bookService.findBook(id);
        Long user_id = (Long) session.getAttribute("user_id");
        if (!book.getCreator().getId().equals(user_id)){
            return "redirect:/book";
        }else {
            model.addAttribute("book", book);
            return "edit.jsp";
        }
    }

    // 2 Updated book
    @RequestMapping(value = "/book/{id}/edit", method = RequestMethod.PUT)
    public String updateBook(@Valid @ModelAttribute("book") Book book,BindingResult result, @PathVariable("id") Long id, HttpSession session){
        System.out.println("hihihi");
        Long user_id = (Long) session.getAttribute("user_id");
        System.out.println(user_id);
        if (session.getAttribute("user_id")== null){
            System.out.println("no user");
            return "redirect:/book";
        }
        if (result.hasErrors()){
            System.out.println("error");
            return "edit.jsp";
        }else {
            System.out.println("request");
            bookService.editBook(book, id);
            return "redirect:/book";
        }
    }

//    // Delete Book
//    @DeleteMapping("/book/{id}/delete")
//    public String deleteBook(@PathVariable("id") Long id, HttpSession session){
//        if (session.getAttribute("user_id") == null){
//            return "redirect:/";
//        }else {
//            bookService.deleteBook(id);
//            return "redirect:/book";
//        }
//    }
}
