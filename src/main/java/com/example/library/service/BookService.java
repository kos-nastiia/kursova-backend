package com.example.library.service;

import java.util.List;
import com.example.library.model.Book;
public interface BookService {
    public Book saveBook(Book book);
    public List<Book> getAllBooks();
    public void deleteBookById(int id, int count);
    public List<Book> getAllBooksSortedByAuthor();
    public List<Book> getAllBooksSortedByYear();
}
