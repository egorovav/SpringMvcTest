package org.egorovav.springmvctest.repository;

import org.egorovav.springmvctest.entitity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
