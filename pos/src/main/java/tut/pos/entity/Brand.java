package tut.pos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brand {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Brand;
    private String Category;

    public Brand(int id, String brand, String category) {
        this.id = id;
        Brand = brand;
        Category = category;
    }

    public Brand() {
        
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Brand [id=" + id + ", Brand=" + Brand + ", Category=" + Category + "]";
    }


}
