package gui.models;

import be.GradeInfo;
import be.Student;
import be.Teacher;
import bll.Person;
import bll.PersonManager;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PersonLogic {
    PersonManager pm = new PersonManager();

    protected void pause() {
        String choice;
        do {
            Scanner input = new Scanner(System.in);
            choice = input.nextLine();
        } while (choice != "");
    }
    public void addStudent() {
        int studentIntID;
        // do {

        System.out.printf("%s : %n", "Please enter the Student ID ");
        Scanner inputID = new Scanner(System.in);
        String studentID = inputID.nextLine();
        studentIntID = Integer.parseInt(studentID);
        //} while (studentIntID!);

        System.out.printf("%s : %n", "Please enter the Student's name ");
        Scanner inputName = new Scanner(System.in);
        String studentName = inputName.nextLine();

        System.out.printf("%s : %n", "Please enter the Student's Education ");
        Scanner inputEducation = new Scanner(System.in);
        String studentEducation = inputEducation.nextLine();

        System.out.printf("%s : %n", "Please enter the Student's Email ");
        Scanner inputEmail = new Scanner(System.in);
        String studentEmail = inputEmail.nextLine();


        System.out.printf("%s : %d,%n%s : %s,%n%s : %s,%n%s : %s%n", "Student ID entered", studentIntID
                , "Student Name entered", studentName
                , "Student Education entered", studentEducation
                , "Student Email entered", studentEmail);

        Student student = new Student(studentIntID, studentName, studentEducation);
        student.setEmail(studentEmail);
        pm.addPerson(student);
        System.out.printf("Student %s has been added, please enter to return to continue %n", studentName);
        pause();
    }

    public void addGradeStudent() {
        System.out.printf("Please enter the Id of the student%n");
        Scanner inputID = new Scanner(System.in);
        String studentID = inputID.nextLine();
        int studentIntID = Integer.parseInt(studentID);

        Student student = (Student) pm.getPerson(studentIntID);

        System.out.printf("Student id : %d Name : %s is currently undergoing education %s%n "
                , studentIntID, student.getName(), student.getEducation());
        System.out.printf("Please add a grade for this student%n");
        Scanner inputGrade = new Scanner(System.in);
        int newGrade = Integer.parseInt(inputGrade.nextLine());
        student.addGrade(new GradeInfo(student.getEducation(), newGrade));
        System.out.printf("Grade %d for student %s added for the education %s%n%nPlease press enter to continue%n%n"
                , newGrade, student.getName(), student.getEducation());
        pause();
    }

    public void viewAllStudent() {
        List<Student> studentList = pm.getAllStudents();
        System.out.printf("%s %20s %45s %25s %35s%n%n", "ID", "NAME", "EMAIL", "EDUCATION", "AVG. Grade");
        for (Student student : studentList) {
            System.out.printf("%s%n", student.toString());
        }
        System.out.printf("Please press enter to continue");
        pause();
    }

    public void removeStudent() {
        System.out.printf("Please enter the Id of the student%n");
        Scanner inputID = new Scanner(System.in);
        String studentID = inputID.nextLine();
        int studentIntID = Integer.parseInt(studentID);

        Student student = (Student) pm.getPerson(studentIntID);

        System.out.printf("Student id : %d Name : %s is currently undergoing education %s%n "
                , studentIntID, student.getName(), student.getEducation());
        System.out.printf("Do you want to Remove this student ? Y/N %n");
        Scanner inputChoice = new Scanner(System.in);
        String choice = inputChoice.nextLine();
        if (choice.toLowerCase(Locale.ROOT).equals("y")) {
            pm.removePerson(studentIntID);
            System.out.printf("Student %s removed from the list of students%n", student.getName());
        } else {
            System.out.printf("Redirecting you to the Student Manager menu %n");
        }
        System.out.printf("Please press enter to continue %n");
        pause();
    }

    public void addTeacher() {
        System.out.printf("%s : %n", "Please enter the Teacher's ID ");
        Scanner inputID = new Scanner(System.in);
        String teacherID = inputID.nextLine();
        int teacherIntID = Integer.parseInt(teacherID);

        System.out.printf("%s : %n", "Please enter the Teacher's name ");
        Scanner inputName = new Scanner(System.in);
        String teacherName = inputName.nextLine();

        System.out.printf("%s : %n", "Please enter the initials you wish to use for the Teacher ");
        Scanner inputInitial = new Scanner(System.in);
        String teacherInitial = inputInitial.nextLine();

        System.out.printf("%s : %n", "Please enter the Teacher Email ");
        Scanner inputEmail = new Scanner(System.in);
        String teacherEmail = inputEmail.nextLine();
        if (teacherName.toLowerCase(Locale.ROOT).contains("peter")) {
            System.out.printf("%s%n%s : %n", "Please enter the Teacher intended Salary (Note: Peter already have enough",
                    "But he went into hunger strike last time his income was too low to buy his favourite candies, you have been warned... ");
        } else {
            System.out.printf("%s : %n", "Please enter the Teacher's intended Salary");
        }
        Scanner inputSalary = new Scanner(System.in);
        double teacherSalary = Double.parseDouble(inputSalary.nextLine());

        System.out.printf("%s : %d,%n%s : %s,%n%s : %s,%n%s : %s,%n%s : %.02f%n", "Teacher ID entered", teacherIntID
                , "Teacher Name entered", teacherName
                , "Initials chosen for the Teacher", teacherInitial
                , "Teacher's Email entered", teacherEmail
                , "Teacher's intended salary entered", teacherSalary);

        Teacher teacher = new Teacher(teacherIntID, teacherName, teacherInitial);
        teacher.setEmail(teacherEmail);
        teacher.setSalary(teacherSalary);
        pm.addPerson(teacher);
        System.out.printf("Teacher %s has been added, please enter to return to continue %n", teacherName);
        pause();
    }

    public void addTeacherEducationSubject() {
        System.out.printf("Please enter the Teacher's ID %n");
        Scanner inputID = new Scanner(System.in);
        String teacherID = inputID.nextLine();
        int teacherIntID = Integer.parseInt(teacherID);

        Teacher teacher = (Teacher) pm.getPerson(teacherIntID);
        List<String> listSubjects = teacher.getSubjects();
        if (listSubjects.size() > 0) {
            System.out.printf("Teacher id : %d Name : %s is currently teaching the following subjects %n "
                    , teacherIntID, teacher.getName());
            for (String s : listSubjects) {
                System.out.printf("%s %n", s);
            }
        } else {
            System.out.printf("Teacher id : %d Name : %s is currently not teaching any subjects %n", teacher.getId(), teacher.getName());
        }

        System.out.printf("Please add a Teaching Subject for this Teacher%n");
        Scanner inputSubject = new Scanner(System.in);
        String newSubject = inputSubject.nextLine();
        teacher.addSubject(newSubject);
        System.out.printf("Subject %s for teacher %s added %n%nPlease press enter to continue%n%n"
                , newSubject, teacher.getName());
        pause();
    }

    public void viewAllTeachers() {
        List<Teacher> teacherList = pm.getAllTeachers();
        System.out.printf("%s %20s %45s %25s %35s%n%n", "ID", "NAME", "EMAIL", "EDUCATION", "AVG. Grade");
        for (Teacher teacher : teacherList) {
            System.out.printf("%s%n", teacher.toString());
        }
        System.out.printf("Please press enter to continue%n");
        pause();
    }

    public void removeTeacher() {
        System.out.printf("Please enter the Id of the teacher%n");
        Scanner inputID = new Scanner(System.in);
        String teacherID = inputID.nextLine();
        int teacherIntID = Integer.parseInt(teacherID);

        Teacher teacher = (Teacher) pm.getPerson(teacherIntID);

        List<String> listSubjects = teacher.getSubjects();
        if (listSubjects.size() > 0) {
            System.out.printf("Teacher's id : %d Name : %s is currently teaching %n "
                    , teacherIntID, teacher.getName());
            for (String s: listSubjects) {
                System.out.printf("%s %n",s);
            }
        } else {
            System.out.printf("Teacher's id : %d Name : %s is currently not teaching any subjects %n "
                    , teacherIntID, teacher.getName());
        }
        System.out.printf("Do you want to Remove this teacher ? Y/N %n");
        Scanner inputChoice = new Scanner(System.in);
        String choice = inputChoice.nextLine();
        if (choice.toLowerCase(Locale.ROOT).equals("y")) {
            System.out.println(teacherIntID);
            try {
                pm.removePerson(teacherIntID);} catch (ConcurrentModificationException e){
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                System.out.println(e.getLocalizedMessage());
            }
            System.out.printf("Teacher %s removed from the list of teachers%n", teacher.getName());
        } else {
            System.out.printf("Redirecting you to the Teacher Manager menu %n");
        }
        System.out.printf("Please press enter to continue %n");
        pause();
    }
    //Todo: Implement this sh.....
    public Person searchByID() {
        System.out.printf("Please enter the Id of the Person you are looking for%n");
        Scanner inputID = new Scanner(System.in);
        String personID = inputID.nextLine();
        int personIntID = Integer.parseInt(personID);
        Person person = pm.getPerson(personIntID);
        if(person== null) {
            System.out.printf("%s ");
        }
        return null;
    }
}
