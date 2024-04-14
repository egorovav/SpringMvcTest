package org.egorovav.springmvctest.repository;

import org.egorovav.springmvctest.entitity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
