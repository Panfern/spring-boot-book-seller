package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Books;

import java.util.List;

public interface IBookService {
    Books saveBook(Books book);

    void deletebook(Long id);

    List<Books> findAllBooks();
}
