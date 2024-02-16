package tut.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.transaction.Transactional;
import tut.pos.dao.BrandRepository;
import tut.pos.dao.ProductRepository;
import tut.pos.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class BrandService {


    @Autowired
    private BrandRepository brandRepository;

    
    @Autowired
    private ProductRepository productRepository;

//   when fetching brands their product should also appear or when fetching products their brand . find the suitable one

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

    // public void addBrand(@RequestBody Brand data){
    //     this.brandRepository.save(data);
    // }

    @Transactional
    public void addBrand(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the TSV line into fields
                String[] fields = line.split("   ");

                String brand = fields[0];
                String category = fields[1].trim();

                Brand b = new Brand();
                b.setBrand(brand);
                b.setCategory(category);

                Product p=new Product();

                p.setBarcode(fields[2]);
                // p.setBrand_category(fields[3]);
                p.setName(fields[4]);
                Double mrp =Double.valueOf(fields[5]);
                p.setMrp(mrp);

                p.setBrand(b);
                List<Product> prod = new ArrayList<>();
                prod.add(p);
                //b.setProduct(prod);
                productRepository.save(p);
                brandRepository.save(b);
                
            }
        } catch (IOException e) {
            // Handle IOException, e.g., log the error
            e.printStackTrace();
            throw new RuntimeException("Error processing TSV file", e);
        }
    }

    // public void deleteBrand(int id){
    //     brandRepository.deleteById(id);
    // }

   

    public void updateBrand(Brand b,int id){
        b.setId(id);
        brandRepository.save(b);
    }
}
