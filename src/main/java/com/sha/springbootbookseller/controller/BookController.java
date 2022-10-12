package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.Books;
import com.sha.springbootbookseller.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping    //            /api/book
    public ResponseEntity<?> saveBook(@RequestBody Books book)
    {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
    } 

    @DeleteMapping("/{id}")   //     /api/book/{id}
    public ResponseEntity<?> deleteBookById(@PathVariable Long id)
    {
        bookService.deletebook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks()
    {
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
    }
}
