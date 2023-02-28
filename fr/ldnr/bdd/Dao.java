package fr.ldnr.bdd;

public interface Dao {
	public Connection connection = Bdd Connection.getConnection();
	public void create(T obj);
	public t read(int id);
	public Boolean update(T obj);
	public boolean delete(T obj);
	public Arraylist<T> readAll();
}
