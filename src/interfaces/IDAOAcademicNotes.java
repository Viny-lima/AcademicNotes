package interfaces;

import java.util.List;

public interface IDAOAcademicNotes<T> {

    public void create(T t);

    public List<T> read();

    public void update(T t);

    public void delete(T t);

}