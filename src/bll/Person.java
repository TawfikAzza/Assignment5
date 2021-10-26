package bll;

import org.w3c.dom.ls.LSOutput;

public abstract class Person {


    private int id;
    private String name;
    private String email;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Person(int id, String name, String email) {
        this(id,name);
        this.email=email;
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public void setName(String name) {this.name = name;}

    public void setId(int id) {this.id = id;}

    public void setEmail(String email) {this.email = email;}

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        if(this.getId()==p.getId()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return String.format("%-15s %-25s %30s ",getId(),getName(),getEmail());
    }
}
