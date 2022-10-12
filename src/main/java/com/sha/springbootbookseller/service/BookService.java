package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Books;
import com.sha.springbootbookseller.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService implements IBookService
{
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books saveBook(Books book)
    {
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deletebook(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Books> findAllBooks()
    {
        return bookRepository.findAll();
    }
}
