package gui.console;

import bll.Menu;
import bll.Action;
import bll.MenuItems;
import gui.models.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {


    private List<Menu> subMenus;
    private List<MenuItems> listMenuItems = new ArrayList<>();
    public MainMenu(MenuModel model, List<Menu> subMenus) {
        super(model.getHeader(), model.getMenuItems());
        this.subMenus = subMenus;
        Action a=null;

    }

    public MainMenu(String header, List<MenuItems> menuItems) {
        super(header, menuItems);
        this.listMenuItems = menuItems;
    }
    @Override
    protected void doAction(int option) {
       // System.out.println("Size submenu = "+subMenus.size());
        listMenuItems.get(option).getAction().run();

    }


}
