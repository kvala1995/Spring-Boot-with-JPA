package com.RestAPI.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.Entity.EntityClass;
import com.RestAPI.Exception.AnimalnotFoundException;
import com.RestAPI.Repository.RepositoryClass;
import com.RestAPI.controller.Animal;

@Service
public class AnimalServiceClass {

	
	@Autowired
	RepositoryClass repobj;
	
	public Animal save(Animal anobj) {
		EntityClass eobj = new EntityClass();
		BeanUtils.copyProperties(anobj, eobj);
		EntityClass enobj = repobj.save(eobj);
		anobj.setId(enobj.getId());
		return anobj;
				
	}
	
	
	public List<Animal> show(){
		List<Animal> result = new ArrayList<>();
		List<EntityClass> eobj = repobj.findAll();
		for(EntityClass entity: eobj) {
			Animal anobj = new Animal();
			BeanUtils.copyProperties(entity,anobj);
			result.add(anobj);
		}
		return result;
	}
	
	
	public boolean deleteId(int id) {
		boolean status = false;
      if(repobj.existsById(id)){
    	  repobj.deleteById(id);
    	  status = true;
      }
      return status;
		
	
	}


	public void update(Animal anobj) {
		// TODO Auto-generated method stub
	     Optional<EntityClass> optional = repobj.findById(anobj.getId());
	     
	     if(optional.isPresent()) {
	    	 EntityClass eobj = optional.get();
		       if(anobj.getName()!=null) {
		    	 eobj.setName(anobj.getName());
		    	 }
		       if(anobj.getWeight()!=null) {
		    	   eobj.setWeight(anobj.getWeight());
		    	   }
	         repobj.save(eobj);
	       }
	     else {
	    	 throw new AnimalnotFoundException("No animal found with Id");
	     }
	}
	
	
	public Animal findById(int id) {
		// TODO Auto-generated method stub
	     Optional<EntityClass> optional = repobj.findById(id);
	     Animal anobj = new Animal();
	     if(optional.isPresent()) {
	    	 
	    	 BeanUtils.copyProperties(optional.get(), anobj);
		       
	       }
	     else {
	    	 throw new AnimalnotFoundException("No animal found with Id");
	     }
	     return anobj;
	}
	
}
