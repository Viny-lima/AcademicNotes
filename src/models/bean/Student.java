package models.bean;

import java.util.List;

public class Student {

    private int id;
    private String name;
    private boolean status;
    public List<Integer> notes;

    public Student() {}

    public Student(String name) 
    {
        this.name = name;
    }

    //Id
    public int getId() {
        return id;
    }            
    public void setId(int id) 
    {
        this.id = id;
    }

    //Name
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }   
    
    //Status
    public boolean isStatus() 
    {
        return status;
    }
    public void setStatus(boolean status) 
    {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        var res = "\n==========================================";
        res += "\nAluno [" + id + "]: " + name;        
        
        if(this.status == true)
        {
            res += " | APROVADO";
        }
        else
        {
            res += " | REPROVADO";
        }        
        if (notes != null) 
        {
            res += "\nCom as seguintes Notas: " + notes.toString();
        }
        else
        {
            res += "\nSem Notas no Sistema";
        }
        res += "\n==========================================\n";

        return res;
    }
}
