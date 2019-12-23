package ru.pavel2107.arch.admin.service;

import ru.pavel2107.arch.admin.domain.catalog.Brand;
import ru.pavel2107.arch.admin.domain.catalog.Category;
import ru.pavel2107.arch.admin.domain.catalog.Good;

import java.util.List;

public interface GoodsService {
    Good find(Long id);
    List<Good> findByName(String name);
    List<Good> findByCategory(Category category);
    List<Good> findByBrand(Brand brand);
    Good findBySkud(Long skud);
    List<Good> findAll();
}
