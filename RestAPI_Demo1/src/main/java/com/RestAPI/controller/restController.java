package com.RestAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kv")
public class restController {
	
	
	
	//endpoint http://localhost:9090/kv/animal
	//this is rest api
	@GetMapping("/animal")
	public List<Animal> show(){
		List<Animal> lobj = new ArrayList<>();
		lobj.add(new Animal("Alex", 146.52));
		lobj.add(new Animal("Kite", 124.52));
		lobj.add(new Animal("Kate", 142.52));
		return lobj;
		
	}
	

	
	//PathVariable - http://localhost:9090/kv/animal/{pathvariable}
	@GetMapping("/rest/{name}")
	public Animal show(@PathVariable String name){
		
		return new Animal(name,89.46);
		
	}
	
	//json objects are passed as parameters to create animal obj here
	@PostMapping("/animal")
	public Animal createAnimal(@RequestBody Animal anobj) {
		System.out.print(anobj);
		return anobj;
	}

}
