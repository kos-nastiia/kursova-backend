package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(int id, int count) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            int currentCount = book.getCount();
            if (currentCount >= count) {
                book.setCount(currentCount - count);
                bookRepository.save(book);
            } else {
                throw new RuntimeException("Not enough books to delete");
            }
        } else {
            throw new RuntimeException("Book with id " + id + " not found");
        }
    }

    @Override
    public List<Book> getAllBooksSortedByAuthor() {
        return bookRepository.findAllSortedByAuthor();
    }

    @Override
    public List<Book> getAllBooksSortedByYear() {
        return bookRepository.findAllSortedByYear();
    }

}
