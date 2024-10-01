package com.springBoot.Bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;
import org.springframework.stereotype.Service;

import com.springBoot.Entity.EntityClass;
import com.springBoot.dao.RepositoryClass;

@Service
public class ProgramClass {
 
	@Autowired
	RepositoryClass repobj;
	
	
		
	public void add(EntityClass eobj) {
		
		repobj.save(eobj);
	}
	
	public List<EntityClass> fetch() {
		
		List<EntityClass> listobj = repobj.findAll();
		return listobj;
	}
	
	public List<EntityClass> delete(Integer id){
		repobj.deleteById(id);
		List<EntityClass> listobj = repobj.findAll();
		return listobj;
	}
	
	public List<EntityClass>  search(Integer id){
		 return List.of(repobj.findById(id).get());
		
	}
	
	public List<EntityClass>  sort(String input,String order){
		List<EntityClass> listobj = repobj.findAll();
		 Comparator<EntityClass> comparator = null;
		switch(input) {
		case "product": 
			comparator = Comparator.comparing(EntityClass::getProduct, String.CASE_INSENSITIVE_ORDER);
		case "category": 
			comparator = Comparator.comparing(EntityClass::getCategory, String.CASE_INSENSITIVE_ORDER);
		}
		if(order.equals("asc")) {
			
		Collections.sort(listobj,comparator);}
		else {
			Collections.sort(listobj,comparator.reversed());
		}
		
		return listobj;
		
	}
}
