package com.springapp.mvc.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 8/4/2015.
 */
@Entity
@Table(name="product")
public class Product implements Serializable
{

    @Id
    @GeneratedValue
    @Column(name="productId")
    private int productId;

    @Column(name="productName")
    private String productName;

    @Column(name="productStock")
    private int productStock;

    @Column(name="productPrice")
    private double productPrice;

    @Column(name="productDescription")
    private String productDescription;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId")
    private Category category;

    public Product()
    {

    }

    public Product(String productName, int productStock, double productPrice,String productDescription)
    {
        this.productName = productName;
        this.productStock = productStock;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productStock=" + productStock +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getProductStock() != product.getProductStock()) return false;
        if (Double.compare(product.getProductPrice(), getProductPrice()) != 0) return false;
        if (!getProductName().equals(product.getProductName())) return false;
        if (!getProductDescription().equals(product.getProductDescription())) return false;
        return getCategory().equals(product.getCategory());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getProductName().hashCode();
        result = 31 * result + getProductStock();
        temp = Double.doubleToLongBits(getProductPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getProductDescription().hashCode();
        result = 31 * result + getCategory().hashCode();
        return result;
    }
}
