package se.liu.malha079.lab3;

import se.liu.malha079.lab1.Person;

import java.time.LocalDate;

public class QueueAndStackQuest
{
    public static void main(String[] args) {
	Queue queue = new Queue();
	queue.add(new Person("Egon", LocalDate.of(2000,1,1)));
	queue.add(new Person("Magon", LocalDate.of(2200,3,4)));
	queue.add(new Person("Igon", LocalDate.of(1200,11,13)));
	queue.add(new Person("Margon", LocalDate.of(2200,3,4)));
	queue.add(new Person("Larggon", LocalDate.of(10010,11,13)));
	while (!queue.isEmpty()){
	    System.out.println(queue.dequeue());
	}

	System.out.println(" ");
	Stack stack = new Stack();
	stack.add(new Person("Egon", LocalDate.of(2000,1,1)));
	stack.add(new Person("Magon", LocalDate.of(2200,3,4)));
	stack.add(new Person("Igon", LocalDate.of(1000,11,13)));
	stack.add(new Person("Margon", LocalDate.of(2200,3,4)));
	stack.add(new Person("Larggon", LocalDate.of(10010,11,13)));
	while (!stack.isEmpty()){
	    System.out.println(stack.pop());
	}


    }
}
