package ru.pavel2107.arch.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.catalog.domain.Brand;
import ru.pavel2107.arch.catalog.domain.Category;
import ru.pavel2107.arch.catalog.domain.Good;

import java.util.List;

public interface GoodRepo extends JpaRepository<Good, Long> {
    List<Good> findByName(String name);
    List<Good> findByCategory(Category category);
    List<Good> findByBrand(Brand brand);
    Good findBySkud(Long skud);
}
