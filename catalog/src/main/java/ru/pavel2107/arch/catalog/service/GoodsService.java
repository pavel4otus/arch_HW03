package ru.pavel2107.arch.catalog.service;

import ru.pavel2107.arch.catalog.domain.Brand;
import ru.pavel2107.arch.catalog.domain.Category;
import ru.pavel2107.arch.catalog.domain.Good;

import java.util.List;

public interface GoodsService {
    Good find(Long id);
    List<Good> findByName(String name);
    List<Good> findByCategory(Category category);
    List<Good> findByBrand(Brand brand);
    Good findBySkud(Long skud);
    List<Good> findAll();
}
