package se.liu.malha079.lab1;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(String name, LocalDate birthDay){
        this.name = name;
        this.birthDay = birthDay;
    }
    public int getAge(){
        Period timeBetween = Period.between(birthDay, LocalDate.now());
        int yearsBetween = timeBetween.getYears();
        return yearsBetween;
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + ", birthDay=" + birthDay + '}';
    }

    public static void main(String[] args) {
        Person malte = new Person("Malte Hammar", LocalDate.of(2001,7,18));
        Person berra = new Person("berra", LocalDate.of(200,3,2));
        System.out.println(malte);
        System.out.println(berra);
    }
}
