package ru.pavel2107.arch.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
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

    // private GoodRepo repository;
    private GoodGeoLocationRepo<GoodMoscow> goodMoscowRepo;
    private GoodGeoLocationRepo<GoodSpb>    goodSpbRepo;
    private GoodGeoLocationRepo<GoodOthers> goodOthersRepo;

    @Autowired
    public GoodsServiceImpl(
            GoodGeoLocationRepo<GoodMoscow> goodMoscowRepo,
            GoodGeoLocationRepo<GoodSpb>    goodSpbRepo,
            GoodGeoLocationRepo<GoodOthers> goodOthersRepo
            ){
        this.goodMoscowRepo = goodMoscowRepo;
        this.goodSpbRepo    = goodSpbRepo;
        this.goodOthersRepo = goodOthersRepo;
    }

    @Override
    public GoodDto find(Long id) {
        GoodSpb    goodSpb    = goodSpbRepo.findById( id).orElse( null);
        GoodMoscow goodMosdow = goodMoscowRepo.findById( id).orElse( null);
        GoodOthers goodOthers  = goodOthersRepo.findById( id).orElse( null);
        GoodDto goodDto = concatObjects( goodMosdow, goodSpb, goodOthers);

        return goodDto;
    }

    @Override
    public GoodDto find(City city, Long id) {
        GoodGeoLocationRepo repo = getRepo( city);
        return (GoodDto) repo.findById( id).orElse( null);
    }

    @Override
    public List<GoodDto> findByName(String name) {
        List<GoodSpb>    goodSpb    = goodSpbRepo.findByName( name);
        List<GoodMoscow> goodMosdow = goodMoscowRepo.findByName( name);
        List<GoodOthers> goodOthers  = goodOthersRepo.findByName( name);
        List<GoodDto> goodDto = concatLists( goodMosdow, goodSpb, goodOthers);

        return goodDto;
    }

    @Override
    public List<GoodDto> findByName(City city, String name) {
        GoodGeoLocationRepo repo = getRepo( city);
        return repo.findByName( name);
    }

    @Override
    public List<GoodDto> findByCategory(Category category) {
        List<GoodSpb>    listSpb    = goodSpbRepo.findByCategory( category);
        List<GoodMoscow> listMosdow = goodMoscowRepo.findByCategory( category);
        List<GoodOthers> listOthers  = goodOthersRepo.findByCategory( category);

        return concatLists( listMosdow, listSpb, listOthers);
    }

    @Override
    public List<GoodDto> findByCategory(City city, Category category) {
        GoodGeoLocationRepo repo = getRepo( city);
        return repo.findByCategory( category);
    }

    @Override
    public List<GoodDto> findByBrand(Brand brand) {
        List<GoodSpb>    listSpb    = goodSpbRepo.findByBrand( brand);
        List<GoodMoscow> listMosdow = goodMoscowRepo.findByBrand( brand);
        List<GoodOthers> listOthers  = goodOthersRepo.findByBrand( brand);

        return concatLists( listMosdow, listSpb, listOthers);

    }

    @Override
    public List<GoodDto> findByBrand(City city, Brand brand) {
        GoodGeoLocationRepo repo = getRepo( city);
        return repo.findByBrand( brand);
    }

    @Override
    public List<GoodDto> findAll() {
        List<GoodSpb>    listSpb    = goodSpbRepo.findAll();
        List<GoodMoscow> listMosdow = goodMoscowRepo.findAll();
        List<GoodOthers> listOthers  = goodOthersRepo.findAll();

        return concatLists( listMosdow, listSpb, listOthers);
    }

    @Override
    public List<GoodDto> findAll(City city) {
        List list = getRepo( city).findAll();
        return list;
    }

    private GoodGeoLocationRepo getRepo( City city){
        GoodGeoLocationRepo repository = null;
        if( city.getCode().equals( "SPB")) {
            repository = goodSpbRepo;
        } else {
            if (city.getCode().equals("MSK")) {
                repository = goodMoscowRepo;
            } else {
                repository = goodOthersRepo;
            }
        }
     return repository;
    }

    private GoodDto toDto( GoodMoscow x){
      return new GoodDto( x.getId(), x.getSkud(), x.getName(), x.getDescription(),
                x.getSmallPictureUrl(),  x.getLargePictureUrl(), x.getCategory(),
                x.getBrand(), x.getWareHouses());
    }

    private GoodDto toDto( GoodSpb x){
        if( x == null)return null;
        return new GoodDto( x.getId(), x.getSkud(), x.getName(), x.getDescription(),
                x.getSmallPictureUrl(),  x.getLargePictureUrl(), x.getCategory(),
                x.getBrand(), x.getWareHouses());
    }

    private GoodDto toDto( GoodOthers x){
        return new GoodDto( x.getId(), x.getSkud(), x.getName(), x.getDescription(),
                x.getSmallPictureUrl(),  x.getLargePictureUrl(), x.getCategory(),
                x.getBrand(), x.getWareHouses());
    }


    private GoodDto concatObjects( GoodMoscow goodMoscow, GoodSpb goodSpb, GoodOthers goodOthers ){
        GoodDto dto = null;
        if( goodMoscow != null){
            dto = toDto( goodMoscow);
        } else{
            if( goodSpb != null) {
                dto = toDto( goodSpb);
            } else {
                dto = toDto( goodOthers);
            }
        }
        return dto;
    }

    private List<GoodDto> concatLists( List<GoodMoscow> listMosdow, List<GoodSpb> listSpb, List<GoodOthers> listOthers){
        List<GoodDto> list1 = listSpb.stream()
                .map( this::toDto)
                .collect(Collectors.toList());

        List<GoodDto> list2 = listMosdow.stream()
                .map( this::toDto)
                .collect(Collectors.toList());

        List<GoodDto> list3 = listOthers.stream()
                .map( this::toDto)
                .collect(Collectors.toList());

        return Stream.concat( Stream.concat( list1.stream(), list2.stream()), list3.stream()).collect(Collectors.toList());

    }

}
