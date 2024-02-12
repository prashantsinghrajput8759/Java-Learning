package com.pos.sales.Service;

import com.pos.sales.Dao.BrandRepository;
import com.pos.sales.Entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        return (List<Brand>) this.brandRepository.findAll();
    }

    public Brand addBrand(Brand brand){
        return this.brandRepository.save(brand);
    }
}
