import java.util.Scanner;
import models.dao.AcademicDAO;
import models.dao.StudentDAO;

public class App {
    public static void main(String[] args) throws Exception {
        
        AcademicDAO.getInstance().initializeDatabase();
               
        mostrarAlunosENotas();                
        
        

        mostrarAlunosENotas();
    }

    public static void mostrarAlunosENotas()
    {
        for (var s : StudentDAO.getInstance().findAll()) 
        {
            System.out.println(s);
        }
    }

    public static void alterarStatusDoAluno()
    {
        Scanner s = new Scanner(System.in);

        System.out.println("ESCOLHA O ID DO ALUNO QUE DESEJA ALTERAR: ");
        var id = s.nextInt();        

        System.out.println("ESCOLHA [1] APROVADO [0] REPROVADO: ");

        boolean status;
        if (s.nextInt() == 1) 
        {
            status = true;
        } 
        else 
        {
            status = false;
        }

        StudentDAO.getInstance().alterStatus(id, status);
    }

    public static void deletarAluno()
    {
        System.out.println("QUAL ID DO ALUNO QUE DESEJA DELETAR: ");
        StudentDAO.getInstance().delete(new Scanner(System.in).nextInt());
    }


}
