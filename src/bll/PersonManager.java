package bll;

import be.Student;
import be.Teacher;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private List<Person> persons;


    public PersonManager(){
        persons = new ArrayList<>();
    }

    public Person getPerson(int idPerson) {
        for (Person p: persons) {
            if(p.getId()==idPerson) {
                return p;
            }
        }
        return null;
    }

    public void addPerson(Person p) {
        boolean existInList=false;
        for (Person pe: persons) {
            if(pe.getId()==p.getId()) {
                existInList=true;
            }
        }
        if(!existInList) {
            persons.add(p);
        }
    }

    public void removePerson(int idPerson) {
        for (Person pe: persons) {
            if(pe.getId()==idPerson) {
                persons.remove(pe);
                System.out.printf("%s%n",pe);
            }
        }
    }

    public List<Person> getAllPersons() {
        List<Person> allPerson = new ArrayList<>();
        for (Person p: persons) {
            if(!(p instanceof Teacher) && !(p instanceof Student)) {
                allPerson.add(p);
            }
        }
        return allPerson;
    }

    public List<Student> getAllStudents() {
        List<Student> allStudent = new ArrayList<>();
        for (Person p: persons) {
            if(p instanceof Student) {
                allStudent.add((Student) p);
            }
        }
        return allStudent;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> allTeacher = new ArrayList<>();
        for (Person p: persons) {
            if(p instanceof Teacher) {
                allTeacher.add((Teacher) p);
            }
        }
        return allTeacher;
    }

//    @Override
//    public boolean equals(Object o) {
//        int idTest = (int) o;
//
//        return true;
//    }
}
