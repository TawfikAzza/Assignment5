package gui.console;

import bll.Menu;
import bll.Subject;
import gui.models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] menuItems = {"Manage Students", "Manage Teachers", "Search a Person by ID "};
        String header = "Welcome to the shitty console app, please make a selection : (Type 7 to EXIT) ";


        String[] menuItemsTeacher = {"Add a Teacher", "Add an education subject","Remove a Teacher", "View all Teachers"};
        String headerTeacher = "Teachers Management Interface, select an option : (Type 7 to EXIT) ";
        MenuModel menuTeacher = new MenuModel(headerTeacher,menuItemsTeacher);
        List<Subject> subMenuTeacher= new ArrayList<>();
        subMenuTeacher.add(new Subject(menuTeacher,()-> {
            menuTeacher.addTeacher();
        }));
        subMenuTeacher.add(new Subject(menuTeacher,()-> {
            menuTeacher.addTeacherEducationSubject();
        }));
        subMenuTeacher.add(new Subject(menuTeacher,()-> {
            menuTeacher.removeTeacher();
        }));
        subMenuTeacher.add(new Subject(menuTeacher,()-> {
            menuTeacher.viewAllTeachers();
        }));

        //subMenuTeacher.add();
        String[] menuItemsStudent = {"Add a Student","Add a grade to a Student", "Remove a Student","View all Students"};
        String headerStudent = "Students Management Interface, select an option :";
        MenuModel menuStudent = new MenuModel(headerStudent,menuItemsStudent);
        List<Subject> subMenuStudent = new ArrayList<>();
        subMenuStudent.add(new Subject(menuStudent,()-> {
            menuStudent.addStudent();
        }));
        subMenuStudent.add(new Subject(menuStudent,()-> {
            menuStudent.addGradeStudent();
        }));
        subMenuStudent.add(new Subject(menuStudent,()-> {
            menuStudent.removeStudent();
        }));
        subMenuStudent.add(new Subject(menuStudent,()-> {
            menuStudent.viewAllStudent();
        }));
        List<Menu> subMenus = new ArrayList<>();
        subMenus.add(new MenuStudent(menuStudent,subMenuStudent));
        subMenus.add(new MenuTeacher(menuTeacher,subMenuTeacher));

        MenuModel mainModel = new MenuModel(header,menuItems);
        MainMenu mainMenu = new MainMenu(mainModel, subMenus);

        mainMenu.run();

    }
}
