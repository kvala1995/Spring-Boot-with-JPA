package com.RestAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


public class Animal {
	
	String name;
	Double weight;
	int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal(String name, Double weight, int id) {
		super();
		this.name = name;
		this.weight = weight;
		this.id = id;
	}

	public Animal() {}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", id=" + id + "]";
	}
	
	
	public Animal(String name, Double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	
	

}
