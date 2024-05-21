package com.example.library.controller;

import java.util.List;
import com.example.library.model.Book;
import com.example.library.service.BookServiceImpl;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public String add(@RequestBody Book book){
        bookService.saveBook(book);
        return "New book is added";
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id, int count) {
        bookService.deleteBookById(id, count);
        return "Book with id " + id + " is deleted";
    }

    @GetMapping("/getAllSortedByAuthor")
    public List<Book> getAllBooksSortedByAuthor(){
        return bookService.getAllBooksSortedByAuthor();
    }

    @GetMapping("/getAllSortedByYear")
    public List<Book> getAllBooksSortedByYear(){
        return bookService.getAllBooksSortedByYear();
    }
}
