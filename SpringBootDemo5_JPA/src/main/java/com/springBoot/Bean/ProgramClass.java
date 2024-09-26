package com.springBoot.Bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;
import org.springframework.stereotype.Service;

import com.springBoot.Entity.EntityClass;
import com.springBoot.dao.RepositoryClass;

@Service
public class ProgramClass {
 
	@Autowired
	RepositoryClass repobj;
		
	public void add(String product,String Category,double price,String photo) {
		EntityClass eobj = new EntityClass();
		eobj.setProduct(product);
		eobj.setCategory(Category);
		eobj.setPrice(price);
		eobj.setPhoto(photo);
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
}
