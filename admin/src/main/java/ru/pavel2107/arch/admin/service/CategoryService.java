package ru.pavel2107.arch.admin.service;


import ru.pavel2107.arch.admin.domain.catalog.Brand;
import ru.pavel2107.arch.admin.domain.catalog.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void delete( Long id);
    Category save(Category brand);
}
