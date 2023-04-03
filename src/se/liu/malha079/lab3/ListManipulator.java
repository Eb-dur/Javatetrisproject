package se.liu.malha079.lab3;

import se.liu.malha079.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ListManipulator

{
    protected List<Person> elements = new ArrayList<>();
    public int size() {
	return elements.size();
    }

    public boolean isEmpty() {
	return elements.isEmpty();
    }

    public boolean contains(final Object o) {
	return elements.contains(o);
    }

    public Iterator<Person> iterator() {
	return elements.iterator();
    }

    protected void add(final Person person) {
	elements.add(person);
    }

    protected Person remove(final int i) {
	return elements.remove(i);
    }

    public void clear() {
	elements.clear();
    }
}
