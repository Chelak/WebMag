package com.springapp.mvc.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
@Entity
@Table(name="category")
public class Category implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="categoryID")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "categoryDescription")
    private String categoryDescription;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!getCategoryName().equals(category.getCategoryName())) return false;
        if (!getCategoryDescription().equals(category.getCategoryDescription())) return false;
        return !(getProducts() != null ? !getProducts().equals(category.getProducts()) : category.getProducts() != null);

    }

    @Override
    public int hashCode() {
        int result = getCategoryName().hashCode();
        result = 31 * result + getCategoryDescription().hashCode();
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        return result;
    }
}
