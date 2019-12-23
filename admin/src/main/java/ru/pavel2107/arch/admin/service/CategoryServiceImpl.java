package ru.pavel2107.arch.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.admin.domain.catalog.Brand;
import ru.pavel2107.arch.admin.domain.catalog.Category;
import ru.pavel2107.arch.admin.repository.catalog.CategoryRepo;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo repository;

    @Autowired
    public CategoryServiceImpl( CategoryRepo repository){
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById( id).orElse( new Category());
    }

    @Override
    public void delete(Long id) {
        Category category = findById( id);
        if( category != null){
            repository.delete( category);
        }
    }

    @Override
    public Category save(Category brand) {
        return repository.save( brand);
    }
}
