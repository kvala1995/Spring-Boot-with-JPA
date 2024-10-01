package com.springBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.Entity.EntityClass;

@Repository
public interface RepositoryClass extends JpaRepository<EntityClass,Integer>{
     
	Optional<EntityClass> findById(Integer id);
}
