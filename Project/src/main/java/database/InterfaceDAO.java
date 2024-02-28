package database;

import java.util.ArrayList;

public interface InterfaceDAO<T> {
	public boolean insert(T t);
	public boolean update(T t);
	public boolean delete(T t);
	public ArrayList<T> selectAll();
	public ArrayList<T> selectByID(String id);
	public ArrayList<T> selectByConditon(String condition);
}
