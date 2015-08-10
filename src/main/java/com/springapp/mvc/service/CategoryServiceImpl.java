package com.springapp.mvc.service;

import com.springapp.mvc.dao.CategoryDAO;
import com.springapp.mvc.dao.CategoryDaoImpl;
import com.springapp.mvc.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */

@Service
public class CategoryServiceImpl implements CategoryService
{
    /*
     *  It will be wired with CategoryDaoImpl, because it has @Repository annotation
     *
     *
     */

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> findAll()
    {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(Integer categoryId)
    {
        return categoryDAO.findById(categoryId);
    }

    @Override
    public void addCategory(Category category)
    {
        categoryDAO.addCategory(category);
    }

    @Override
    public void editCategory(Category category, Integer categoryId)
    {
        categoryDAO.editCategory(category,categoryId);
    }

    @Override
    public void removeCategory(Integer categoryId)
    {
        categoryDAO.removeCategory(categoryId);
    }



}
