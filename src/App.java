import models.dao.AcademicDAO;

public class App {
    public static void main(String[] args) throws Exception {
        
        AcademicDAO.getInstance().DeleteDatabase();
        AcademicDAO.getInstance().initializeDatabase();   
        
    }
}
