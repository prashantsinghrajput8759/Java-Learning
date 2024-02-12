package com.pos.sales.Service;

import com.pos.sales.Entities.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getBrands();
    public Brand addBrand(Brand brand);

}
