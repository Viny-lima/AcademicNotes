import models.dao.AcademicDAO;

public class App {
    public static void main(String[] args) throws Exception {
        
        var dao = AcademicDAO.getInstance();
        dao.initializeDatabase();       

    }
}
