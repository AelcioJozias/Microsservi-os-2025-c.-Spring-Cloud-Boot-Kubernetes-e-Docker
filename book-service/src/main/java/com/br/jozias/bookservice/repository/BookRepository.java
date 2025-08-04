package com.br.jozias.bookservice.repository;


import com.br.jozias.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
