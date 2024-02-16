package tut.pos.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String barcode;

    private String name;
    private double mrp;
    @ManyToOne
    @JoinColumn(name ="brand_category")
    @JsonBackReference
    private Brand brand;
    // @JoinColumn(name = "foreign_key", referencedColumnName = "Brand" )
    

   
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

  
    public Product(int id, String barcode, String brand_category, String name, double mrp,Brand b) {
        this.id = id;
        this.barcode = barcode;
        // this.brand_category = brand_category;
        this.name = name;
        this.mrp = mrp;
        this.brand=b;
    }

    public Product(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    // public String getBrand_category() {
    //     return brand_category;
    // }

    // public void setBrand_category(String brand_category) {
    //     this.brand_category = brand_category;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }




}
