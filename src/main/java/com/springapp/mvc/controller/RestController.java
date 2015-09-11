package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Category;
import com.springapp.mvc.domain.Product;
import com.springapp.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by user on 9/11/2015.
 */
@Controller
@RequestMapping(value = "/api")
public class RestController
{
            @Autowired
            ProductService productService;

        @RequestMapping(value = "/product/random", method = RequestMethod.GET, produces = "application/json")
        public @ResponseBody List<Product> productRandom()
        {
            return productService.findAll();
        }

        @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = "application/json")
        public @ResponseBody Product getById(@PathVariable Integer id)
        {
            return productService.findById(id);
        }

        @RequestMapping(value = "/product", method = RequestMethod.POST)

        public @ResponseBody String saveProduct(Product product)
        {
            productService.addProduct(product);
            return "Save product: "+ product.toString();
        }
}
