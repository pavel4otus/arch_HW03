package ru.pavel2107.arch.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.catalog.domain.Brand;
import ru.pavel2107.arch.catalog.domain.Category;
import ru.pavel2107.arch.catalog.domain.Good;

import java.util.List;

public interface GoodGeoLocationRepo<T> extends JpaRepository<T, Long> {
    List<T> findByName(String name);
    List<T> findByCategory(Category category);
    List<T> findByBrand(Brand brand);
    T findBySkud(Long skud);
}
