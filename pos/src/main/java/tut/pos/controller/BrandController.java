package tut.pos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tut.pos.entity.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tut.pos.services.BrandService;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class BrandController {
    

    @Autowired
    private BrandService brandService;

    @GetMapping("/brand")
    public List<Brand> getBrand(){
        List<Brand> brand= this.brandService.getAllBrand();
        return brand;
    }

    @GetMapping("/brand/{id}")
    public Brand getBrand(@PathVariable("id") int id){
        return brandService.getBrandById(id);
    }

    // @PostMapping("/brand")
    // public void setBrand(@RequestBody Brand brand){
    //     this.brandService.addBrand(brand);
    // }

    @PostMapping("/brand")
    public ResponseEntity addBrand(@RequestParam("file") MultipartFile file) {
        try {
            this.brandService.addBrand(file.getInputStream());
            String successMessage = "File added successfully";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } catch (IOException e) {
            
            e.printStackTrace();
            String errorMessage = "Error processing file: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }


    

}
