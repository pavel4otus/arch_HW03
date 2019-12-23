package ru.pavel2107.arch.admin.service;


import ru.pavel2107.arch.admin.domain.catalog.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand findById(Long id);
    void delete( Long id);
    Brand save( Brand brand);
}
