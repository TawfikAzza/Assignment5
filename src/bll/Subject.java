package bll;

import gui.models.MenuModel;

public class Subject {
    private Action[] actions;
    private MenuModel model;

    public void executeAction(int option) {
        actions[option].run();
    }

    public MenuModel getModel() {
        return model;
    }


    public Action[] getActions() {
        return actions;
    }
    public Subject(MenuModel model, Action[] action) {
        this.actions = action;
        this.model = model;
    }

}
