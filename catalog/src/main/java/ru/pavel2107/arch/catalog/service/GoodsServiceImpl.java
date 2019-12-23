package ru.pavel2107.arch.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.catalog.domain.Brand;
import ru.pavel2107.arch.catalog.domain.Category;
import ru.pavel2107.arch.catalog.domain.Good;
import ru.pavel2107.arch.catalog.repository.GoodRepo;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodRepo repository;

    @Autowired
    public GoodsServiceImpl( GoodRepo repository){
        this.repository = repository;
    }

    @Override
    public Good find(Long id) {
        return repository.findById( id).orElse( null);
    }

    @Override
    public List<Good> findByName(String name) {
        return repository.findByName( name);
    }

    @Override
    public List<Good> findByCategory(Category category) {
        return repository.findByCategory( category);
    }

    @Override
    public List<Good> findByBrand(Brand brand) {
        return repository.findByBrand( brand);
    }

    @Override
    public Good findBySkud(Long skud) {
        return repository.findBySkud( skud);
    }

    @Override
    public List<Good> findAll() {
        return repository.findAll();
    }
}
