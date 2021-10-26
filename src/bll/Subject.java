package bll;

import gui.models.MenuModel;

public class Subject {
    private Action action;
    private MenuModel model;

    public void executeAction() {
         action.run();
    }

    public MenuModel getModel() {
        return model;
    }



    public Subject(MenuModel model, Action action) {
        this.action = action;
        this.model = model;
    }

}
