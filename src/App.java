import models.bean.Student;
import models.dao.AcademicDAO;
import models.dao.StudentDAO;

public class App {
    public static void main(String[] args) throws Exception {
        
        AcademicDAO.getInstance().initializeDatabase();   
        var studentDAO = StudentDAO.getInstance();
        studentDAO.create(new Student("Vinicius Lima"));

    }
}
