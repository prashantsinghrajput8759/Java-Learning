package tut.pos.controller;

import org.springframework.web.bind.annotation.RestController;

import tut.pos.entity.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import tut.pos.services.BrandService;

import java.util.List;



@RestController
public class BookController {
    

    @Autowired
    private BrandService brandService;

    @GetMapping("/brand")
    public List<Brand> getBrand(){
        List<Brand> brand= this.brandService.getAllBrand();
        return brand;
    }

}
