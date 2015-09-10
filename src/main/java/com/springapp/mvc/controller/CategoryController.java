package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Category;
import com.springapp.mvc.domain.Product;
import com.springapp.mvc.service.CategoryService;
import com.springapp.mvc.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController
{

   @Autowired
    private CategoryService categoryService;




    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView categoryHome()
    {
       /* // set view: /category/list.jsp
        ModelAndView modelAndView = new ModelAndView("/category/list");
        // return list of categories to be displayed on /category/list.jsp
        modelAndView.addObject("list","categories", categoryService.findAll());
      */
        List<Category> categories = categoryService.findAll();
       return  new ModelAndView("category/list","categories", categories);
    }

    @RequestMapping(value="/addConfirm", method=RequestMethod.POST)
    public ModelAndView categoryAddConfirm(@ModelAttribute Category category) {

        // set view: redirect to /category/
        ModelAndView modelAndView = new ModelAndView("redirect:/category/");

        // add new Category from form entry from ModelAttribute
        // ModelAttribute object comes from object that binded by commandName in the form
        categoryService.addCategory(category);

        return modelAndView;
    }

      // {categoryId} --; path variable from hyperlink.
         // Example: /category/edit/1
    @RequestMapping(value="/edit/{categoryId}", method=RequestMethod.GET)
    public ModelAndView categoryEditForm(@PathVariable Integer categoryId) {
        // set view: /category/edit.jsp
        ModelAndView modelAndView = new ModelAndView("/category/edit");

        // find desired category to edit by using categoryId
        Category categoryEdit = categoryService.findById(categoryId);

        // return Category object that will be binded by edit.jsp as commandName
        // Different from add form, this object already have a value.
        modelAndView.addObject("categoryEdit", categoryEdit);

        return modelAndView;
    }

    @RequestMapping(value="/edit/editConfirm", method=RequestMethod.POST)
    public ModelAndView categoryEditConfirm(@ModelAttribute Category category) {

        // set view: redirect to /category/
        ModelAndView modelAndView = new ModelAndView("redirect:/category/");

        // Update Category from edit form
        categoryService.editCategory(category, category.getCategoryId());

        return modelAndView;
    }

    @RequestMapping(value="/delete/{categoryId}", method=RequestMethod.GET)
    public ModelAndView categoryAddConfirm(@PathVariable Integer categoryId) {

        ModelAndView modelAndView = new ModelAndView("redirect:/category/");

        categoryService.removeCategory(categoryId);

        return modelAndView;
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public String getProductByCategory(@PathVariable Integer categoryId, ModelMap model)
    {


        Category getCategoryById = categoryService.findById(categoryId);
        model.addAttribute("categoryId", getCategoryById.getCategoryId());
        model.addAttribute("categoryName", getCategoryById.getCategoryName());
        model.addAttribute("categoryDescription", getCategoryById.getCategoryDescription());

        return "category/list";

    }
}

