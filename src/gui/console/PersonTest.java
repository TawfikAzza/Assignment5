package gui.console;

import be.GradeInfo;
import be.Student;
import bll.Person;
import be.Teacher;
import bll.PersonManager;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {


    public static void main(String[] args) {


        PersonManager personManager = new PersonManager();


        List<Person> persons = new ArrayList<>();
//        Person person1 = new Person(100 ,"Hans Nielsen");
//        person1.setEmail("hni@easv.dk");
//        Person person2 = new Person(101 ,"Niels Hansen");
//        person2.setEmail("nha@easv.dk");
//        Person person3 = new Person(102 ,"Ib Boesen");
//        person3.setEmail("ibo@easv.dk");


        Teacher teacher1 = new Teacher(202,"Bent H. Pedersen","bhp");
        teacher1.setEmail("bhp@easv.dk");
        teacher1.addSubject("PROGRAMMING");
        Teacher teacher2 = new Teacher(203,"Jeppe Moritz Led","jml");
        teacher2.setEmail("jle@easv.dk");
        teacher2.addSubject("SCO1");
        teacher2.addSubject("DATABASE");
        Teacher teacher3 = new Teacher(204,"Peter Stegger Nielsen","psn");
        teacher3.setEmail("pgn@easv.dk");
        teacher3.addSubject("SDE1");
        teacher3.addSubject("JAVAFX ARCHITECTURE");

        Student student1 = new Student(105,"Bo Ibsen","CS");
        student1.setEmail("bib@easv.dk");
        student1.addGrade(new GradeInfo("CS",9));
        student1.addGrade(new GradeInfo("CS",8));

//        personManager.addPerson(person1);
//        personManager.addPerson(person2);
//        personManager.addPerson(person3);

        personManager.addPerson(teacher1);
        personManager.addPerson(teacher2);
        personManager.addPerson(teacher3);

        personManager.addPerson(student1);

        List<Person> personList = new ArrayList<>();
        personList = personManager.getAllPersons();

        List<Teacher> teacherList = new ArrayList<>();
        teacherList = personManager.getAllTeachers();

        List<Student> studentList = new ArrayList<>();
        studentList = personManager.getAllStudents();


       /*
        //Adding persons
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        //Adding teachers
        persons.add(teacher1);
        persons.add(teacher2);
        persons.add(teacher3);

        persons.add(student1);*/



        System.out.printf("%s %20s %45s%n%n","ID","NAME","EMAIL");

        for (Person p: personList) {
            System.out.printf("%s%n", p.toString());
        }
        System.out.printf("%n%n");

        System.out.printf("%s %20s %45s %25s %35s%n%n","ID","NAME","EMAIL","INITIALS","MAIN");

        for (Teacher t: teacherList) {
            System.out.printf("%s%n", t.toString());
        }
        System.out.printf("%n%n");

        System.out.printf("%s %20s %45s %25s %35s%n%n","ID","NAME","EMAIL","EDUCATION","AVG. Grade");

        for (Student s: studentList) {
            System.out.printf("%s%n", s.toString());
        }
    }
}
