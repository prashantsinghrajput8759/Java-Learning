package tut.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tut.pos.dao.BrandRepository;
import tut.pos.dao.ProductRepository;

import tut.pos.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;


    public List<Product> getAllProducts() {
        List<Product> list = (List<Product>)this.productRepository.findAll();
        return list;
    }

    public Product getProductById(int id){
        Product product =null;
        try{
            product=this.productRepository.findById(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }


    @Transactional
    public void addProducts(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the TSV line into fields
                String[] fields = line.split("   ");

                String barcode = fields[0];
                String brand = fields[1];
                String name = fields[2];
                double mrp = Double.parseDouble(fields[3]);
                int brandId=Integer.parseInt(fields[4]);

                Product p = new Product();
                p.setBarcode(barcode);
                // b.setBrand_category(brand);
                p.setName(name);
                p.setMrp(mrp);
                Brand b= brandRepository.findById(brandId);
                p.setBrand(b);
                this.productRepository.save(p);

               
            

            }
        } catch (IOException e) {
            // Handle IOException, e.g., log the error
            e.printStackTrace();
            throw new RuntimeException("Error processing TSV file", e);
        }
    }

    // public void deleteBrand(int id){
    //     productRepository.deleteById(id);
    // }

    public void updateBrand(Product b,int id){
        b.setId(id);
        productRepository.save(b);
    }
}
