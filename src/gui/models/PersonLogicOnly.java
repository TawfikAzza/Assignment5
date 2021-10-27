package gui.models;

import be.GradeInfo;
import be.Student;
import be.Teacher;
import bll.Person;
import bll.PersonManager;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class PersonLogicOnly {

    PersonManager pm = new PersonManager();

    protected void pause() {
        String choice;
        do {
            Scanner input = new Scanner(System.in);
            choice = input.nextLine();
        } while (choice != "");
    }

    public void addStudent(int studentIntID, String studentName, String studentEducation, String studentEmail) {
        Student student = new Student(studentIntID, studentName, studentEducation);
        student.setEmail(studentEmail);
        pm.addPerson(student);
    }

    public void addGradeStudent(Student student,int newGrade) {
        student.addGrade(new GradeInfo(student.getEducation(), newGrade));
    }

    public List<Student> viewAllStudent() {
        return pm.getAllStudents();
    }

    public void removeStudent(int studentID) {
        pm.removePerson(studentID);
    }

    public void addTeacher(Teacher teacher) {
        pm.addPerson(teacher);
    }

    public void addTeacherEducationSubject(Teacher teacher, String newSubject) {
        teacher.addSubject(newSubject);
    }

    public List<Teacher> viewAllTeachers() {
        return pm.getAllTeachers();
    }

    public void removeTeacher(int teacherID) {

            try {
                pm.removePerson(teacherID);
            } catch (ConcurrentModificationException e){
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                System.out.println(e.getLocalizedMessage());
            }

    }
    /* Implement this */
    public Person searchByID(int idPerson) {
        return null;
    }
}
