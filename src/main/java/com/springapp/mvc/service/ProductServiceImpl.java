package com.springapp.mvc.service;

import com.springapp.mvc.dao.ProductDAO;
import com.springapp.mvc.dao.ProductsDaoImpl;
import com.springapp.mvc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
public class ProductServiceImpl implements ProductService
{
    /*
     * It will be wired with ProductRepositoryDB, because it has @Repository annotation
     *
     */
    @Autowired
    private ProductDAO productDAO;



    @Override
    public List<Product> findAll()
    {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Integer productId)
    {
        return productDAO.findById(productId);
    }

    @Override
    public void addProduct(Product product)
    {
        productDAO.addProduct(product);
    }

    @Override
    public void editProduct(Product product, Integer productId)
    {
        productDAO.editProduct(product,productId);
    }

    @Override
    public void removeProduct(Integer productId)
    {
        productDAO.removeProduct(productId);
    }
}
