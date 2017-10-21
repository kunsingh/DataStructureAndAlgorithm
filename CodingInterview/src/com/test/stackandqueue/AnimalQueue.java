package com.test.stackandqueue;

import java.util.LinkedList;

class Animal {
	private int order;
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isOlderThan(Animal animal) {
		return this.order < animal.order;
	}
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}
class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

public class AnimalQueue {
	LinkedList<Dog> dogList = new LinkedList<Dog>();
	LinkedList<Cat> catList = new LinkedList<Cat>();
	private int order =0;
	public void enqueue(Animal a){
		a.setOrder(order++);
		if(a instanceof Dog){
			dogList.addLast((Dog)a);
		}else if(a instanceof Cat){
			catList.addLast((Cat)a);
		}
	}
	
	public Animal dequeue(){
		if(dogList.size()==0){
			return dequeueCats();
		}
		if(catList.size()==0){
			return dequeueDogs();
		}
		Dog dog = dogList.peek();
		Cat cat = catList.peek();
		if(dog.isOlderThan(cat)){
			return dequeueDogs();
		}else{
			return dequeueCats();
		}
	}

	private Animal dequeueDogs() {
		return dogList.poll();
	}

	private Animal dequeueCats() {
		return catList.poll();
	}
}
