package ru.pavel2107.arch.catalog.service;

import ru.pavel2107.arch.catalog.domain.*;
import ru.pavel2107.arch.catalog.dto.GoodDto;

import java.util.List;

public interface GoodsService {
    GoodDto find(Long id);
    GoodDto find(City city, Long id);

    List<GoodDto> findByName(String name);
    List<GoodDto> findByName(City city, String name);

    List<GoodDto> findByCategory(Category category);
    List<GoodDto> findByCategory(City city, Category category);

    List<GoodDto> findByBrand(Brand brand);
    List<GoodDto> findByBrand(City city, Brand brand);

    List<GoodDto> findAll();
    List<GoodDto> findAll(City city);

}
