package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
@Repository
public class CategoryDaoImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory; // session factory object

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Category> findAll() {
        return getCurrentSession().createQuery("from Category").list();
    }

    @Override
    @Transactional
    public Category findById(Integer categoryId) {
        return (Category) getCurrentSession().get(Category.class,categoryId);
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        getCurrentSession().save(category);
    }

    @Override
    @Transactional
    public void editCategory(Category category, Integer categoryId)
    {
        /**
         * get current category to edit
         */
        Category categoryToUpdate = findById(categoryId);
        /**
         * set new params to categoryToUpdate if not null
          */
        if (categoryToUpdate != null)
        {
            categoryToUpdate.setCategoryName(category.getCategoryName());
            categoryToUpdate.setCategoryDescription(category.getCategoryDescription());
            getCurrentSession().update(categoryToUpdate);
            getCurrentSession().flush();
        }
    }

    @Override
    @Transactional
    public void removeCategory(Integer categoryId)
    {
        /**
         * find the category which will be removed, find by id category
         */
        Category categoryToDelete = findById(categoryId);
        /**
         * check whether there is this category
          */
        if(categoryToDelete != null) {
            getCurrentSession().delete(categoryToDelete);

            getCurrentSession().flush();
        }
    }
}
