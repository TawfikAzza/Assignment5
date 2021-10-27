package gui.console;

import bll.Menu;
import bll.MenuItems;
import bll.Subject;
import gui.models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class MenuTeacher extends Menu {
    private List<Subject> subMenus;
    private List<MenuItems> listMenuItems = new ArrayList<>();
    public MenuTeacher(String header, String[] menuItems) {
        super(header, menuItems);
    }
    public MenuTeacher(MenuModel menuTeacher, List<Subject> subMenus) {
        super(menuTeacher.getHeader(),menuTeacher.getMenuItems());
        this.subMenus = subMenus;
    }
    public MenuTeacher(String header, List<MenuItems> menuItems){
        super(header, menuItems);
        this.listMenuItems = menuItems;
    }

    @Override
    protected void doAction(int option) {
        listMenuItems.get(option).getAction().run();
    }
}
