package gui.console;

import bll.Menu;
import bll.Action;
import gui.models.*;

import java.util.List;

public class MainMenu extends Menu {


    private List<Menu> subMenus;

    public MainMenu(MenuModel model, List<Menu> subMenus) {
        super(model.getHeader(), model.getMenuItems());
        this.subMenus = subMenus;
        Action a=null;

    }

    @Override
    protected void doAction(int option) {
        System.out.println("Size submenu = "+subMenus.size());
        subMenus.get(option).run();

    }


}
