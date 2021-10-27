package gui.console;

import bll.Menu;
import bll.MenuItems;
import bll.PersonManager;
import gui.models.PersonLogic;

import java.util.ArrayList;
import java.util.List;
/*
* If this is the first file you open on this project, I suggest you visit the MenuItems file first as
* a lot going on in this page is explained over there...
* If you already visited it, please be my guest for the following (nothing fancy)
*
* So, this class is the main caller of the everything that make this project works.
* This project (still unfinished and still subject to modifications)
* is articulated around the fact that a menu is a collection of number selection, label (or text didplayed)
* to choose and an associated action.
* if you can make it so that the method that call either the menu for display or the action to perform have the same name,
* you can call either the action of performing a task like adding or removing a teacher or student
* OR the submenu if it exists.
* Explanation: to call the display of a menu, the method used is named run(), the signature of it is:
* public void run();
* this method call for the display of a header(a String passed in argument in the constructor of a Menu
*  and the display of the choice available in the menu through an array of String, also passed in argument in the constructor
*
* The genius of Jeppe's idea in lieu and place of passing a String for the header and an array of String in the constructor
* is to instead pass a String for the header and a LIST of MenuItems Objects composed of a selection Number, a String
* for the label of the choice and an Action type variable (a method which is defined in PersonLogic) which will be executed
* also via a run() method defined in the Interface Action.
* In essence we encapsulated the name of the method (for example addStudent() by another method which is run())
* so When run is called through the interface, the compiler will go look at what is inside the method run in the interface,
* and thanks to the Functional interface capabilities of JAVA will execute the method specified in the declaration of said
* functional interface.
* The setting up of this architecture is realised in the class Main which you are actually reading.
* SO let's go take a look...
*
* */
public class Main {
    public static void main(String[] args) {
        PersonLogic pl = new PersonLogic();
        /*
        * Here, the first thing I do is declaring a PersonLogic instance in order to have access to all the method I
        * implemented in it and will be used in the appication.
        *
        * Then, I declare three list of MenuItems type.
        * These list will store a variable number of MenuItems instance.
        * As explained in the MenuItems class, these instances are a "link" of sort between a number of selection, a label,
        * as well as an action associated.
        * There is three list corresponding to the choices for the main menu, the student manager menu as well as
        * the teacher manager menu.
        * I also declare a header for each of the menu, in order to welcome the user we he/she reach one the menu
        * */
        List<MenuItems> listMainMenu = new ArrayList<>();
        List<MenuItems> listMenuItemTeacher = new ArrayList<>();
        List<MenuItems> listMenuItemStudent = new ArrayList<>();

        PersonManager pm = new PersonManager();


        /*
        * The way to add a correspondence between a selection number, a label and an action is pretty straightforward
        * and the logic behind it is explained in detail in the MenuItems class
        * As the Main Menu is composed of two submenus, I have to first declare and set the two sub menus before
        * adding them to the main menu.
        * I therefore declare a number associated for to the Item selection (an int), a label fot the item (a String),
        * as well a method associated.
        * Note that I had to change the way the abstract class Menu handle the menu displayed through the show() method
        * to accomodate the fact that it would deal with a List and not an array, do visit this class to learn more about it,
        * I don't think commenting it would be useful, (i.e: I may or may not do it...)
        * the :: is called a Lambda expression and even though it may seem imposing is nothing to be afraid about,
        * it just allows someone to call a method by refering to the class instead of using the dot (.) operator.
        * this operation is called "method reference operator" if you want to google it and learn more about it.
        * IntelliJ proposed it itself when I was struggling to set up my lists, so I own no credit for using it.
        * I am still as shitty a programmer as I was before...no quantum leap, unfortunately :D
        *
        * */

        listMenuItemTeacher.add(new MenuItems(0,"Add a Teacher", pl::addTeacher));
        listMenuItemTeacher.add(new MenuItems(1,"Add an education subject", pl::addTeacherEducationSubject));
        listMenuItemTeacher.add(new MenuItems(2,"Remove a Teacher", pl::removeTeacher));
        listMenuItemTeacher.add(new MenuItems(3,"View all Teachers", pl::viewAllTeachers));
        /*
        * I then create a MenuTeacher object with a different constructor than the one we have been given in the UML
        * of the assignment, to accomodate the fact that the menu is now a List and not an Array.
        * According to Jeppe, Array is also good to use, so feel free to do something similar with an array !
        *
        * */
        String headerTeacher = "Teachers Management Interface, select an option : (Type 7 to EXIT) ";
        MenuTeacher menuTeacher = new MenuTeacher(headerTeacher, listMenuItemTeacher);

        //I then do the same with the Student Menu
        listMenuItemStudent.add(new MenuItems(0,"Add a Student",pl::addStudent));
        listMenuItemStudent.add(new MenuItems(1,"Add a grade to a Student",pl::addGradeStudent));
        listMenuItemStudent.add(new MenuItems(2,"Remove a Student",pl::removeStudent));
        listMenuItemStudent.add(new MenuItems(3,"View all Students",pl::viewAllStudent));

        String headerStudent = "Students Management Interface, select an option : (Type 7 to EXIT)";
        MenuStudent menuStudent = new MenuStudent(headerStudent,listMenuItemStudent);

        /*
        * Main menu header declaration and assignement of the menuTeacher and menuStudent as a MenuItems type of
        * data.
        * Note that the menu here is called without a reference to its run() method that is because, the menuStudent and
        * menuTeacher already have a run method, and as at the moment of the selection, the DoAction in the main menu will
        * use the run() method of the interface, and the interface being implemented by the Meny abstract class, the
        * run() method will be called not by its usual dot (.) connection, but by the run method of the Interface !!
        * Now say it, SAY IT! do you feel the genius behind Jeppe's idea ?
        * I just implemented what he told me to, and understood the genius behind only at the late stage of my
        * implementations....
        * Do buy him some cookies if you learned something from my pitiful code here.
        *
        * So now if I want to add a new menu, I just have to declare its class, and add the corresponding methods name
        * here after having implemented them in the PersonLogic class.
        * this is a good way to separate the logic layer, the control as well as the datas.
        * */
        String header = "Welcome to the shitty console app, please make a selection : (Type 7 to EXIT) ";
        listMainMenu.add(new MenuItems(0,"Manage Students", menuStudent));
        listMainMenu.add(new MenuItems(1,"Manage Teachers", menuTeacher));
        listMainMenu.add(new MenuItems(2,"Search a Person by ID",pl::searchByID));

        MainMenu mainMenu = new MainMenu(header,listMainMenu);
        List<Menu> subMenus = new ArrayList<>();

        mainMenu.run();

    }
}

//Rubbish code ahead,
/*
    String[] menuItems = {"Manage Students", "Manage Teachers", "Search a Person by ID "};
    String header = "Welcome to the shitty console app, please make a selection : (Type 7 to EXIT) ";
    PersonManager pm = new PersonManager();

    String[] menuItemsTeacher = {"Add a Teacher", "Add an education subject","Remove a Teacher", "View all Teachers"};
    String headerTeacher = "Teachers Management Interface, select an option : (Type 7 to EXIT) ";
    Action[] actions = {
            ()->{
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

            } ,
            () -> {
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
                // pause();
            } ,
            () -> {
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
                //pause();
            } ,
            () -> {
                List<Teacher> teacherList = pm.getAllTeachers();
                System.out.printf("%s %20s %45s %25s %35s%n%n", "ID", "NAME", "EMAIL", "EDUCATION", "AVG. Grade");
                for (Teacher teacher : teacherList) {
                    System.out.printf("%s%n", teacher.toString());
                }
                System.out.printf("Please press enter to continue%n");
                // pause();
            }
    };
    MenuModel menuTeacher = new MenuModel(headerTeacher,menuItemsTeacher);

    List<Subject> subMenuTeacher= new ArrayList<>();
        subMenuTeacher.add(new Subject(menuTeacher,actions));


                //subMenuTeacher.add();
                String[] menuItemsStudent = {"Add a Student","Add a grade to a Student", "Remove a Student","View all Students"};
                String headerStudent = "Students Management Interface, select an option :";
                MenuModel menuStudent = new MenuModel(headerStudent,menuItemsStudent);
                List<Subject> subMenuStudent = new ArrayList<>();
        Action[] actionStudent = {
        ()-> {
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
        //pause();
        },
        ()-> {
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
        // pause();
        } ,
        ()-> {
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
        //pause();
        } ,
        ()-> {
        List<Student> studentList = pm.getAllStudents();
        System.out.printf("%s %20s %45s %25s %35s%n%n", "ID", "NAME", "EMAIL", "EDUCATION", "AVG. Grade");
        for (Student student : studentList) {
        System.out.printf("%s%n", student.toString());
        }
        System.out.printf("Please press enter to continue");
        //pause();
        }
        } ;
        subMenuStudent.add(new Subject(menuStudent,actionStudent));
        List<Menu> subMenus = new ArrayList<>();
        subMenus.add(new MenuStudent(menuStudent,subMenuStudent));
        subMenus.add(new MenuTeacher(menuTeacher,subMenuTeacher));

        MenuModel mainModel = new MenuModel(header,menuItems);
        MainMenu mainMenu = new MainMenu(mainModel, subMenus);

        mainMenu.run();
*/
//        subMenuTeacher.add(new Subject(menuTeacher));
//        }));
//
//        subMenuTeacher.add(new Subject(menuTeacher,()-> {
//            menuTeacher.addTeacher();
//        }));
//        subMenuTeacher.add(new Subject(menuTeacher,()-> {
//            menuTeacher.addTeacherEducationSubject();
//        }));
//        subMenuTeacher.add(new Subject(menuTeacher,()-> {
//            menuTeacher.removeTeacher();
//        }));
//        subMenuTeacher.add(new Subject(menuTeacher,()-> {
//            menuTeacher.viewAllTeachers();
//        }));
