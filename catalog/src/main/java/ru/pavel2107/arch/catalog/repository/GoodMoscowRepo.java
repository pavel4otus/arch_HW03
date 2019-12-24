package ru.pavel2107.arch.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.catalog.domain.Brand;
import ru.pavel2107.arch.catalog.domain.Category;
import ru.pavel2107.arch.catalog.domain.Good;
import ru.pavel2107.arch.catalog.domain.GoodMoscow;

import java.util.List;

public interface GoodMoscowRepo<T> extends JpaRepository<T, Long> {
    List<Good> findByName(String name);
    List<Good> findByCategory(Category category);
    List<Good> findByBrand(Brand brand);
    Good findBySkud(Long skud);
}
