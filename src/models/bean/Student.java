package models.bean;

import java.util.List;

public class Student {

    private int id;
    private String name;
    public List<Integer> notas;

    //Id
    public int getId() {
        return id;
    }    
    public void setId(int id) {
        this.id = id;
    }

    //Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
    
}
