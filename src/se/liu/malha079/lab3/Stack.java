package se.liu.malha079.lab3;

import se.liu.malha079.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack extends ListManipulator
{
    public void push(Person person){
        add(person);
    }

    public Person pop(){
        int size = size();
        return remove(size - 1);
    }
}
