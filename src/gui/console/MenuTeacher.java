package gui.console;

import bll.Menu;
import bll.Subject;
import gui.models.MenuModel;

import java.util.List;

public class MenuTeacher extends Menu {
    private List<Subject> subMenus;
    public MenuTeacher(String header, String[] menuItems) {
        super(header, menuItems);
    }
    public MenuTeacher(MenuModel menuStudent, List<Subject> subMenus) {
        super(menuStudent.getHeader(),menuStudent.getMenuItems());
        this.subMenus = subMenus;
    }

    @Override
    protected void doAction(int option) {
        subMenus.get(option).executeAction();
    }
}
