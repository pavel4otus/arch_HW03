package ru.pavel2107.arch.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.admin.domain.catalog.Brand;
import ru.pavel2107.arch.admin.repository.catalog.BrandRepo;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepo repository;

    @Autowired
    public BrandServiceImpl( BrandRepo repository){
        this.repository = repository;
    }

    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return repository.findById( id).orElse( new Brand());
    }

    @Override
    public void delete(Long id) {
        Brand brand = repository.findById( id).orElse( null);
        if( brand != null) {
            repository.delete(brand);
        }
    }

    @Override
    public Brand save(Brand brand) {
        return repository.save( brand);
    }
}
