package com.springBoot.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.Bean.ChartClass;
import com.springBoot.Bean.ProgramClass;
import com.springBoot.Entity.EntityClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

@Controller
public class ServletClass {
	
	@Autowired
	ProgramClass pobj;
	
	@Autowired
    private ChartClass chartService;
 
	@GetMapping({"/Page","/"})
	public String load(HttpServletRequest req) {
		req.setAttribute("productlist", pobj.fetch());
		return "index";
	}
	
	@GetMapping("/search") 
	//@requestparam is same as request.getparameter
	public String search(@RequestParam Integer search,org.springframework.ui.Model model) {
		model.addAttribute("productlist",pobj.search(search));
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
	public String process(@ModelAttribute EntityClass entityclass,Model model) {
		
		
		pobj.add(entityclass);
		model.addAttribute("productlist", pobj.fetch());
		model.addAttribute("message","Product added");
	    return "index";
		
	}
	
	@GetMapping("/sorting")
	public String process(@RequestParam String sortBy,@RequestParam String orderBy,Model model) {
		if(orderBy.equals("asc")) {
			model.addAttribute("orderBy", "dsc");
		 model.addAttribute("productlist",pobj.sort(sortBy, orderBy));}
		else {
			model.addAttribute("orderBy", "asc");
			model.addAttribute("productlist",pobj.sort(sortBy, orderBy));
		}
	    return "index";
		
	}
	
	
	@GetMapping("api/chart")
    public ResponseEntity<byte[]> getChart() throws IOException {
        BufferedImage chart = chartService.generateBarChart();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(chart, "png", byteArrayOutputStream);
        byte[] chartBytes = byteArrayOutputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/png");

        return new ResponseEntity<>(chartBytes, headers, HttpStatus.OK);
    }
	
	 
}
