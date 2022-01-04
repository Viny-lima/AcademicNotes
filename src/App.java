import models.dao.AcademicDAO;
import models.dao.StudentDAO;

public class App {
    public static void main(String[] args) throws Exception {
        
        AcademicDAO.getInstance().initializeDatabase();

        var studentDAO = StudentDAO.getInstance();

        for (var s : studentDAO.read()) 
        {
            System.out.println(s);
        }
            
        
    }
}
