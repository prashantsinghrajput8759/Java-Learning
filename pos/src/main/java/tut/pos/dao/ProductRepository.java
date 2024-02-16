package tut.pos.dao;

import org.springframework.data.repository.CrudRepository;


import tut.pos.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{
    public Product findById(int id);

}


