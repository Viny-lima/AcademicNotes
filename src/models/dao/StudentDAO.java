package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import interfaces.IDAOAcademicNotes;
import models.bean.Student;

public class StudentDAO implements IDAOAcademicNotes<Student>
{       
    private final String nameDatabase;
    private Connection connectionDb;
    private PreparedStatement statement;
    private ResultSet result;

    //Singleton
    private static final StudentDAO INSTANCE = new StudentDAO();

    public static StudentDAO getInstance() 
    {

        return INSTANCE;

    }

    private StudentDAO() 
    {
        var academicDAO = AcademicDAO.getInstance();        
        nameDatabase = academicDAO.getNameDatabase();
        connectionDb = ConnectionFactory.getConnectionDataBase();
    }

    @Override
    public void create(Student student)
    {
        try 
        {
            connectionDb = ConnectionFactory.getConnectionDataBase();

            statement = connectionDb.prepareStatement("use " + nameDatabase + ";");
            statement.executeUpdate();

            statement = connectionDb.prepareStatement("INSERT INTO STUDENTS ( STUDENT_NAME , STUDENT_STATUS ) VALUES (?,?)");

            statement.setString(1, student.getName());
            statement.setBoolean(2, student.isStatus());

            statement.executeUpdate();

            System.out.println("Salvo com sucesso o Aluno: " + student.getName());
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao salvar o Aluno: " + student.getName() + "\nERRO: " + e);
        }
        finally
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement);
        }
    }

    @Override
    public List<Student> read() 
    {

        var listStudents = new ArrayList<Student>();

        try 
        {
            connectionDb = ConnectionFactory.getConnectionDataBase();

            statement = connectionDb.prepareStatement("use " + nameDatabase + ";");
            statement.executeUpdate();

            statement = connectionDb.prepareStatement("SELECT * FROM STUDENTS");
            result =  statement.executeQuery();

            while(result.next())
            {
                var student = new Student();

                student.setId(result.getInt("STUDENT_ID"));
                student.setName(result.getString("STUDENT_NAME"));
                student.setStatus(result.getBoolean("STUDENT_STATUS"));

                listStudents.add(student);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao listar Alunos: " + e);
        } 
        finally 
        {
            ConnectionFactory.closeConnectionDataBase(connectionDb, statement, result);
        }

        return listStudents;
        
    }

    @Override
    public void update(Student student)
    {

        
    }

    @Override
    public void delete(Student student) 
    {

        
    }

}
