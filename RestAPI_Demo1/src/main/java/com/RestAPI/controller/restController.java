package com.RestAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.Service.AnimalServiceClass;


@RestController
@RequestMapping("/kv")
public class restController {
	
	
	final private AnimalServiceClass animalserviceObj;
	
	
	//Constructor injection
	public restController(AnimalServiceClass animalserviceObj) {
		this.animalserviceObj = animalserviceObj;
	}
	
	
	//endpoint http://localhost:9090/kv/animal
	//this is rest api
	@GetMapping("/animal")
	public List<Animal> show(){
		List<Animal> lobj = new ArrayList<>();
		lobj.add(new Animal("Alex", 146.52,1));
		lobj.add(new Animal("Kite", 124.52,2));
		lobj.add(new Animal("Kate", 142.52,3));
		return lobj;
		
	}
	
	@GetMapping("animal/{id}")
	public ResponseEntity<Animal> DBAshow(@PathVariable int id){
		Animal anobj = animalserviceObj.findById(id);
		return new ResponseEntity<Animal>(anobj,HttpStatus.OK);
	}
	
	@GetMapping("animal/database")
	public List<Animal> DBAshow(){
		return animalserviceObj.show();	
	}
	
	//PathVariable - http://localhost:9090/kv/animal/{pathvariable}
	@GetMapping("/{name}")
	public Animal show(@PathVariable String name){
		
		return new Animal(name,89.46,1);
		
	}
	//201 --created
	//json objects are passed as parameters to create animal obj here
	@PostMapping("/animal")
	public ResponseEntity<Animal> createAnimal(@RequestBody Animal anobj) {
		Animal aNobj = animalserviceObj.save(anobj);
		return new ResponseEntity<Animal>(aNobj,HttpStatus.CREATED);
	} 
	
	@PutMapping("/animal")
	public ResponseEntity<Animal> UpdateAnimal(@RequestBody Animal anobj) {
		animalserviceObj.update(anobj);
		return new ResponseEntity<Animal>(anobj,HttpStatus.OK);
	} 
	
	@DeleteMapping("/animal/{id}")
	public ResponseEntity<Void> deleteID(@PathVariable int id){
		boolean status =  animalserviceObj.deleteId(id);
		return new ResponseEntity<Void>(status? HttpStatus.NO_CONTENT:HttpStatus.NOT_FOUND);
	}

	
}
