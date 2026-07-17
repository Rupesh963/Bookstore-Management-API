package com.projectlabs.bookstore_api.repository;

import com.projectlabs.bookstore_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}