package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class StudentDAO {
    
    public void create()
    {
        Connection connectionDb = ConnectionFactory.getConnectionDataBase();
        PreparedStatement statement = null;

        try 
        {
            statement = connectionDb.prepareStatement("");
        } 

        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }

}
