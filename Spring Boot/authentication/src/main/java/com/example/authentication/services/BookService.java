package com.example.authentication.services;

import com.example.authentication.models.Book;
import com.example.authentication.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    // Return All Books
    public List<Book> allBook(){
        return bookRepository.findAll();
    }
    // Create Book
    public Book createBook(Book book,Long userId){
        book.setUserId(userId);
        return bookRepository.save(book);
    }

    // Find Book
    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        }else {
            return null;
        }
    }

    // Delete Book
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    // Edit Book
    public Book editBook(Book book, Long id){
        Book book1 = findBook(id);
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setThoughts(book.getThoughts());
        return bookRepository.save(book1);
    }
}
