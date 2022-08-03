package com.example.bookClub.repositories;

import com.example.bookClub.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository <Book, Long> {
    List<Book> findAll();
}
