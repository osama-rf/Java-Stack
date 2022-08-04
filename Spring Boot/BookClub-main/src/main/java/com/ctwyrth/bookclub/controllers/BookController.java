package com.ctwyrth.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ctwyrth.bookclub.models.Book;
import com.ctwyrth.bookclub.models.User;
import com.ctwyrth.bookclub.services.BookService;
import com.ctwyrth.bookclub.services.UserService;

@Controller
public class BookController {
    // -----------------------variables-----------------------
    @Autowired
    private BookService bookService;
    
    @Autowired
    private UserService userService;
    
    // show all on dashboard from login 
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		List<Book> books = bookService.allBooks();
    		model.addAttribute("user", currentUser);
    		model.addAttribute("books", books);
    		return "/books/home.jsp";
    	}
    }
    
    // create one logged in
    @GetMapping("/books/new")
    public String index(@ModelAttribute("book") Book book, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		List<Book> books = bookService.allBooks();
    		model.addAttribute("user", currentUser);
    		model.addAttribute("books", books);
    		return "/books/addBook.jsp";
    	}
    }
    @PostMapping("/books/new")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		model.addAttribute(currentUser);
	    	if (result.hasErrors()) {
	    		List<Book> books = bookService.allBooks();
	        	model.addAttribute("books", books);
	    		return "/books/addBook.jsp";
	    	} else {
	    		book.setUser(currentUser);
	    		bookService.createBook(book);
	    		return "redirect:/home";
	    	}
    	}
    }

    // display one found by id
    @GetMapping("/books/{id}")
    public String showOnebookById(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		Book bookToShow = bookService.findBook(id);
    		model.addAttribute("user", currentUser);
    		model.addAttribute("book", bookToShow);
    		return "/books/show.jsp";
    	}
    }

    // update one found by id
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		Book bookToShow = bookService.findBook(id);
    		model.addAttribute("user", currentUser);
    		model.addAttribute("book", bookToShow);
    		return "/books/edit.jsp";
    	}
    }
    @PutMapping("/books/{id}/edit")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		Book oldBookInfo = bookService.findBook(book.getId());
    		User borrower = oldBookInfo.getBorrower();
	    	if (result.hasErrors()) {
	    		Book bookToShow = bookService.findBook(id);
	    		model.addAttribute("user", currentUser);
	    		model.addAttribute("book", bookToShow);
	        	return "/books/edit.jsp";
	    	} else {
	    		book.setUser(currentUser);
	    		book.setBorrower(borrower);
	    		bookService.updateBook(book);
	    		return "redirect:/home";
	    	}
    	}
    }
    
    // borrow a book
    @PutMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = userService.findUser(userId);
    		Book borrowedBook = bookService.findBook(id);
    		borrowedBook.setBorrower(currentUser);
    		bookService.updateBook(borrowedBook);
    		return "redirect:/home";
    	}
    }
    
    // return a book
    @PutMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		Book borrowedBook = bookService.findBook(id);
    		borrowedBook.setBorrower(null);
    		bookService.updateBook(borrowedBook);
    		return "redirect:/home";
    	}
    }

    // delete one
    @DeleteMapping("/books/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/home";
    }
}