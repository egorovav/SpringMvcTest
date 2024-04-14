package org.egorovav.springmvctest.repository;

import org.egorovav.springmvctest.entitity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
