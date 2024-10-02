package com.RestAPI.controller;

public class Animal {
	
	String name;
	Double weight;
	
	
	public Animal() {}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + "]";
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
