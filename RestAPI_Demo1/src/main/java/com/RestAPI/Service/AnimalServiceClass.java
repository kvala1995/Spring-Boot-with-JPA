package com.RestAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.Entity.EntityClass;
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
	
	
	public void deleteId(int id) {
		EntityClass eobj = new EntityClass();
		repobj.deleteById(id);
		repobj.save(eobj);
	}
	
}
