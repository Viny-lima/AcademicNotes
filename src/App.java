import models.bean.Student;
import models.dao.StudentDAO;

public class App {
    public static void main(String[] args) throws Exception {
        
        StudentDAO dao = new StudentDAO();

        Student s = new Student();
        s.setName("Gabriel Silva");

        dao.create(s);
    }
}
