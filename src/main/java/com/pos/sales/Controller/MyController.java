package com.pos.sales.Controller;


import com.pos.sales.Entities.Brand;
import com.pos.sales.Service.BrandServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private BrandServiceImp brandService;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return this.brandService.getBrands();
    }

    @PostMapping("/brands")
    public Brand addBrand(@RequestBody Brand brand) {
        return this.brandService.addBrand(brand);
    }
}
