package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connection.ConnectionFactory;
import models.bean.Student;

public class AcademicDAO 
{    
    private static boolean isInitialize = true;
    private final String nameDatabase; 
    private Connection connectionDb;
    private PreparedStatement statement;       

    // Singleton
    private static final AcademicDAO INSTANCE = new AcademicDAO();

    public static AcademicDAO getInstance()
    {
        return INSTANCE;
    }

    private AcademicDAO() {
        connectionDb = ConnectionFactory.getConnectionDataBase();
        nameDatabase = "dbAcademicNotes";
    }

    public void initializeDatabase()
    {
        createDataBase();

        if(isInitialize)
        {           
            createTableStudents();
            createTableNote();

            var studentDAO = StudentDAO.getInstance();
            studentDAO.create(new Student("Vinicius Lima"));
            studentDAO.create(new Student("Roberto Braga"));
            studentDAO.create(new Student("Samanta Santos"));
            studentDAO.create(new Student("Thiago Oliveira"));
            studentDAO.create(new Student("Rebeca Andrade"));
            studentDAO.create(new Student("Neymar Francisco"));
            studentDAO.create(new Student("Pedro Lucas"));
            studentDAO.create(new Student("Mateus Silva"));
            studentDAO.create(new Student("Lucas Mattos"));
            studentDAO.create(new Student("Letícia Biatriz"));
            studentDAO.create(new Student("Maria Clara"));
            studentDAO.create(new Student("Ana Gabriela"));
            studentDAO.create(new Student("Samantha Araújo"));
            studentDAO.create(new Student("Felipe Santos"));            
        }
    }

    public void DeleteDatabase()
    {
        try 
        {
            statement = connectionDb.prepareStatement("DROP DATABASE IF EXISTS " + nameDatabase);
            statement.executeUpdate();

            System.out.println("Banco deletado com Sucesso: " + nameDatabase);
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao deletar o Banco de dados: " + nameDatabase + "\nERRO: " + e);
        } 
        finally 
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement);
        } 

    }

    public String getNameDatabase()
    {
        return nameDatabase;
    }

    private void createDataBase() 
    {        
        try 
        {
            connectionDb = ConnectionFactory.getConnectionDataBase();
            statement = connectionDb.prepareStatement("CREATE DATABASE " + nameDatabase + ";");
            statement.executeUpdate();

            System.out.println("Banco Criado com Sucesso: " + nameDatabase);
        } 
        catch (SQLException e) 
        {
            //SE DATA EXISTS NÂO INICIAREMOS ELE NOVAMENTE
            isInitialize = false;
        } 
        finally 
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement);            
        }
    }

    private void createTableStudents()
    {
        try 
        {
            connectionDb = ConnectionFactory.getConnectionDataBase();            
            useDatabase();

            var sql = new StringBuilder();
            sql.append(" CREATE TABLE IF NOT EXISTS STUDENTS (");
            sql.append(" STUDENT_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,");
            sql.append(" STUDENT_NAME varchar(50),");
            sql.append(" STUDENT_STATUS BIT );");

            statement = connectionDb.prepareStatement(sql.toString());

            statement.executeUpdate();

            System.out.println("Table Students criada com Sucesso");
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao criar Table Students: " +  e);
        } 
        finally 
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement);
        }
    }

    private void createTableNote() 
    {        
        try 
        {

            connectionDb = ConnectionFactory.getConnectionDataBase();
            useDatabase();

            var sql = new StringBuilder();
            sql.append("CREATE TABLE IF NOT EXISTS NOTES (");
            sql.append("NOTE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,");
            sql.append("NOTE_VALUE DOUBLE,");
            sql.append("STUDENT_ID INT,");
            sql.append("CONSTRAINT FK_STUDENTS FOREIGN KEY (STUDENT_ID) REFERENCES STUDENTS (STUDENT_ID)");
            sql.append(");");

            statement = connectionDb.prepareStatement(sql.toString());
            statement.executeUpdate();

            System.out.println("Table Notes criada com Sucesso");
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao criar Table Notes: " + e);
        } 
        finally 
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement);
        }
    }

    private void useDatabase()
    {
        try 
        {
            statement = connectionDb.prepareStatement("use " + nameDatabase);
            statement.executeUpdate();
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro: use " + nameDatabase + ": " + e);
        }
    }

}
