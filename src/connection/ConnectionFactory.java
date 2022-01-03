package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {
    
    //Referenciando a classs padrão do jdbc
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    //Passando porta de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost/3306/dbAcademicNotes";
    private static final String USER = "root";
    private static final String PASSWORD = "ifpe2022";

    public static Connection getConnectionDataBase(){
        
        try 
        {

            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        
        catch (ClassNotFoundException | SQLException e) 
        {            
            throw new RuntimeException("ERRO CONNECTION DATABASE: ", e);
        } 

    }

    public static void closeConnectionDataBase(Connection connection)
    {
        
        try 
        {

            if(connection != null)
            {
                connection.close();                    
            }

        } 

        catch (SQLException e) 
        {
            throw new RuntimeException("ERRO DISPOSE DATABASE: ", e);
        }    
            
    }

    public static void closeConnectionDataBase(Connection connection, PreparedStatement statement) 
    {

        closeConnectionDataBase(connection);

        try {

            if (statement != null) {

                statement.close();

            }

        }

        catch (SQLException e) {
            throw new RuntimeException("ERRO DISPOSE DATABASE: ", e);
        }

    }

    public static void closeConnectionDataBase(Connection connection, PreparedStatement statement, ResultSet rs) {

        closeConnectionDataBase(connection, statement);

        try {

            if (rs != null) {

                rs.close();

            }

        }

        catch (SQLException e) {
            throw new RuntimeException("ERRO DISPOSE DATABASE: ", e);
        }

    }

}
