package be;

import bll.Person;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<String> subjects = new ArrayList<>();
    private String initials;
    private double salary;


    public Teacher(int id, String name, String intials) {
        super(id, name);
        this.initials=intials;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    @Override
    public String toString() {
        return String.format("%s %20s %40s",super.toString(),getInitials(),subjects.get(0));
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getInitials() {
        return initials;
    }

    public double getSalary() {
        return salary;
    }


}
