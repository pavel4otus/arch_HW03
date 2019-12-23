package ru.pavel2107.arch.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.catalog.domain.Brand;
import ru.pavel2107.arch.catalog.domain.Category;
import ru.pavel2107.arch.catalog.domain.Good;
import ru.pavel2107.arch.catalog.service.BrandService;
import ru.pavel2107.arch.catalog.service.CategoryService;
import ru.pavel2107.arch.catalog.service.GoodsService;

import java.util.List;

@RestController
public class CatalogController {

    private GoodsService goodsService;
    private BrandService brandService;
    private CategoryService categoryService;

    @Autowired
    public CatalogController(GoodsService goodsService, BrandService brandService, CategoryService categoryService){
        this.goodsService = goodsService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @GetMapping( value = "/microservices/v1/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Good> listGoods(){
        List <Good> list = goodsService.findAll();
        return  list;
    }

    @GetMapping( value = "/microservices/v1/catalog/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategories(){
        List <Category> list = categoryService.findAll();
        return  list;
    }

    @GetMapping( value = "/microservices/v1/catalog/bycategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Good> listGoodsByCategory(@RequestParam Long categoryId){
        Category category = categoryService.findById( categoryId);
        List <Good> list = goodsService.findByCategory( category);
        return  list;
    }

    @GetMapping( value = "/microservices/v1/catalog/bybrand", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Good> listGoodsByBrand(@RequestParam Long brandId){
        Brand brand = brandService.findById( brandId);
        List <Good> list = goodsService.findByBrand( brand);
        return  list;
    }

    @GetMapping( value = "/microservices/v1/catalog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Good get( @PathVariable( value = "id") Long id){
        Good good = goodsService.find( id);
        return good;
    }
}
