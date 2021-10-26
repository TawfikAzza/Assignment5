package gui.console;

import bll.Menu;
import bll.Subject;
import gui.models.MenuModel;

import java.util.List;

public class MenuStudent extends Menu{
    private List<Subject> subMenus;
    MenuStudentModel msm = new MenuStudentModel();
    public MenuStudent(MenuModel menuStudent, List<Subject> subMenus) {
        super(menuStudent.getHeader(),menuStudent.getMenuItems());
        this.subMenus = subMenus;
    }

    @Override
    protected void doAction(int option) {
        subMenus.get(option).executeAction();
    }


    public MenuStudent(String header, String[] menuItems) {
        super(header, menuItems);
    }


//    public static void main(String[] args) {
//        String[] menuItemsStudent = {"Return to Main Menu", "Add a Student","Add a grade to a Student", "Remove a Student","View all Students"};
//        String headerStudent = "Student Management Interface, select an option :";
//        MenuStudent menuStudent = new MenuStudent(headerStudent,menuItemsStudent);
//        menuStudent.run();
//    }
}
