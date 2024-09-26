package com.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBoot.Bean.ProgramClass;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ServletClass {
	
	@Autowired
	ProgramClass pobj;
 
	@GetMapping("/Page")
	public String load(HttpServletRequest req) {
		req.setAttribute("productlist", pobj.fetch());
		req.setAttribute("message","Product added");
		return "index";
	}
	
	@GetMapping("/deleteproduct")
		public String delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		pobj.delete(Integer.parseInt(id));
		req.setAttribute("productlist", pobj.fetch());
		return "index";
	}
	
	@PostMapping("/add")
	public String process(HttpServletRequest req) {
		String product = req.getParameter("product");
		String category = req.getParameter("category");
		double price = Double.parseDouble(req.getParameter("price"));
		String photo = req.getParameter("photo");
		
		pobj.add(product, category, price, photo);
		req.setAttribute("productlist", pobj.fetch());
		req.setAttribute("message","Product added");
	    return "index";
		
	}
}
