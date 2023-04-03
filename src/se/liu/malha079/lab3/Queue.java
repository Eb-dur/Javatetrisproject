package se.liu.malha079.lab3;

import se.liu.malha079.lab1.Person;

import java.util.ArrayList;
import java.util.List;

public class Queue extends ListManipulator
{

    public void enqueue(Person person){
        add(person);
    }

    public Person dequeue(){
        return remove(0);
    }
}
