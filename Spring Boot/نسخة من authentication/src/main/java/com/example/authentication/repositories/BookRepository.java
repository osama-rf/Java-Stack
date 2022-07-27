package com.example.authentication.repositories;

import com.example.authentication.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository <Book, Long> {
    List<Book> findAll();
}
