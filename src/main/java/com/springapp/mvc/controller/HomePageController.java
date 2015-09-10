package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Product;
import com.springapp.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping({"/", "/home"})
public class HomePageController

{	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public  ModelAndView homePage(ModelMap model)
	{

		model.addAttribute("message", "Hello world!");
		List<Product> products = productService.findAll();


		return new ModelAndView("home","products", products);
	}
}