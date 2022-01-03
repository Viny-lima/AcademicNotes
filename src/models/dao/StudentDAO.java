package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import models.bean.Student;

public class StudentDAO {
    
    public void create(Student s)
    {
        Connection connectionDb = ConnectionFactory.getConnectionDataBase();
        PreparedStatement statement = null;

        try 
        {
            statement = connectionDb.prepareStatement("INSERT INTO STUDENTS (NAME_STUDENT) VALUES (?)");

            statement.setString(1, s.getName());

            statement.executeUpdate();

            System.out.println("Salvo com sucesso o Aluno: " + s.getName());
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao salvar o Aluno: " + s.getName() + "\nERRO: " + e);
        }
        finally
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement);
        }

    }

}
