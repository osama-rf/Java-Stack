package com.osama.mvc.services;

// ...
import com.osama.mvc.models.Book;
import com.osama.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Book updateBook = findBook(id);

        updateBook.setTitle(title);
        updateBook.setDescription(desc);
        updateBook.setLanguage(lang);
        updateBook.setNumberOfPages(numOfPages);
        return bookRepository.save(updateBook);
    }
}

