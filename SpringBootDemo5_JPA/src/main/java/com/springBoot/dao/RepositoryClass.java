package com.springBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.Entity.EntityClass;

@Repository
public interface RepositoryClass extends JpaRepository<EntityClass,Integer>{
     
}
