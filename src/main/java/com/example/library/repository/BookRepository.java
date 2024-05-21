package com.example.library.repository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b ORDER BY b.year")
    List<Book> findAllSortedByYear();

    @Query("SELECT b FROM Book b ORDER BY b.author")
    List<Book> findAllSortedByAuthor();
}
