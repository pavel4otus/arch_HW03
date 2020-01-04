package ru.pavel2107.arch.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.catalog.Utils;
import ru.pavel2107.arch.catalog.domain.*;
import ru.pavel2107.arch.catalog.dto.GoodDto;
import ru.pavel2107.arch.catalog.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodRepo repository;

    @Autowired
    public GoodsServiceImpl(
            GoodRepo repository
    ){
        this.repository = repository;
    }

    @Override
    public GoodDto find(Long id) {
        Good good = repository.findById( id).orElse( new Good());
        GoodDto dto  = Utils.toDto( good);
        return dto;
    }

    @Override
    public List<GoodDto> findByName(String name) {
        List<Good> goods    = repository.findByName( name);
        List<GoodDto> dtos = goods
                                .stream()
                                .map( g -> Utils.toDto( g))
                                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<GoodDto> findByCategory(Category category) {
        List<Good> goods = repository.findByCategory( category);
        List<GoodDto> dtos = Utils.toDtoList( goods);

        return dtos;
    }

    @Override
    public List<GoodDto> findByBrand(Brand brand) {
        List<Good> goods = repository.findByBrand( brand);
        List<GoodDto> dtos = Utils.toDtoList( goods);

        return dtos;
    }

    @Override
    public List<GoodDto> findAll() {
        List<Good> goods = repository.findAll();
        List<GoodDto> dtos = Utils.toDtoList( goods);

        return dtos;
    }
}
