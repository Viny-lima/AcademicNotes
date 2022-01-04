package interfaces;

public interface IDAOAcademicNotes<T> {

    public void create(T t);

    public T read(T t);

    public void update(T t);

    public void delete(T t);

}