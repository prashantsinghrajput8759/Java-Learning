package tut.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tut.pos.dao.BrandRepository;
import tut.pos.entity.*;
import java.util.List;

@Component
public class BrandService {


    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrand() {
        List<Brand> list = (List<Brand>)this.brandRepository.findAll();
        return list;
    }

    public Brand getBrandById(int id){
        Brand brand =null;
        try{
            brand=this.brandRepository.findById(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return brand;
    }

    public Brand addBrand(Brand b){
        Brand result=brandRepository.save(b);
        return result;
    }

    public void deleteBrand(int id){
        brandRepository.deleteById(id);
    }

    public void updateBrand(Brand b,int id){
        b.setId(id);
        brandRepository.save(b);
    }
}
