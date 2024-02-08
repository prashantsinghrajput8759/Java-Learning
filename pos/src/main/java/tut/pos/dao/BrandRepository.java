package tut.pos.dao;

import org.springframework.data.repository.CrudRepository;

import tut.pos.entity.Brand;

public interface BrandRepository extends CrudRepository<Brand,Integer>{
    public Brand findById(int id);

}


