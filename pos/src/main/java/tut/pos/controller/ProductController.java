package tut.pos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tut.pos.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tut.pos.services.ProductService;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class ProductController {
    

    @Autowired
    private ProductService ProductService;

    @GetMapping("/Product")
    public List<Product> getProduct(){
        List<Product> Product= this.ProductService.getAllProducts();
        return Product;
    }

    @GetMapping("/Product/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return ProductService.getProductById(id);
    }

    @PostMapping("/Product")
    public ResponseEntity addProduct(@RequestParam("file") MultipartFile file) {
        try {
            this.ProductService.addProducts(file.getInputStream());
            String successMessage = "File added successfully";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } catch (IOException e) {
            
            e.printStackTrace();
            String errorMessage = "Error processing file: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    

}
