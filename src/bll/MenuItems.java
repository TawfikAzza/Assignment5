package bll;

public class MenuItems {
    /*
    * This class has been implemented in order to store the number for the menu,
    * a label for the Choice as well as an action associated
    * the different action available are defined in the class
    * PersonLogic and are in essence a wrapping up of the method we have been asked to implement
    * in the PersonManager class.
    * The Action class is in fact an interface which host only one method signature.
    * the method signature is
    *
    * public void run();
    *
    * This choice has been made because the method from the Menu Abstract Class which launch an Instance of the menu
    * i.e: display of the header, and display of the items in the menu array (meaning the choices)
    * is also a public method run().
    * the genius of this solution has been given to me by Jeppe, our teacher and was at the start of
    * my many hours of struggling afterwards.....however, it was worth it.
    *
    * The action interface is called at the instantiation of concrete method (I use the term concrete here
    * to specify a method which will execute a concrete action (add a student , remove a teacher , list of students....)
    * and not "only" displaying a menu which is not accomplishing anything beside displaying rows of static lines to the user.
    *
    * So the instance of Action which is defined as a functional interface (ask Jeppe about it, I understood only the name and
    * my brain fried.....)
    * will actually be used to "store" so to say a method execution, meaning that in the instance of the class MenuItems
    * will be stored the name as well as reference to the method associated with the instance variables "itemText" and
    * "selectionNumber".
    *
    * It is a lot to take in, but think of it as a making a correspondance between three differents variable,
    * we store all the variables in the same class (for example name,email, date of birth) into a variable Person,
    * and when we want the specific bith date of a Person already in the program, we just use the reference to the class
    * and we know the date of birth will correspond to the name and email entered during the instanciation.
    *
    * So in the end this class associate a choice number in the menu with the text corresponding to that choice AND
    * the method to use if that choice is picked.
    * Simple right ? =) if you understood it right away, congratulations, you are at least 200 IQ higher than me,
    * it took me three days to understand that....
    * The way to instanciate this class is given in the class Main which is the central class in this program
    * Do go take a look :)
    * */

    private int selectionNumber;
    private String itemText;
    private Action action;


    public MenuItems(int selectionNumber, String itemText, Action action) {
        this.selectionNumber = selectionNumber;
        this.itemText = itemText;
        this.action = action;
    }

    public int getSelectionNumber() {
        return selectionNumber;
    }

    public void setSelectionNumber(int selectionNumber) {
        this.selectionNumber = selectionNumber;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
