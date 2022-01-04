package models.bean;

public class Student {

    private int id;
    private String name;
    private boolean status;

    //Id
    public int getId() {
        return id;
    }        
    public boolean isStatus() {
        return status;
    }

    //Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
    
    //Status
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
