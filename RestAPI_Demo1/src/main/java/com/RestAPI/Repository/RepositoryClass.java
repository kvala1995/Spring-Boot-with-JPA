package com.RestAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.Entity.EntityClass;

@Repository
public interface RepositoryClass extends JpaRepository<EntityClass, Integer> {

}
