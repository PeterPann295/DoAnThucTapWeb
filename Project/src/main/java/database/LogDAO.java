package database;

import java.util.ArrayList;

public class LogDAO implements InterfaceDAO<Log>{

    @Override
    public boolean insert(Log log) {
        return false;
    }

    @Override
    public boolean update(Log log) {
        return false;
    }

    @Override
    public boolean delete(Log log) {
        return false;
    }

    @Override
    public ArrayList<Log> selectAll() {
        return null;
    }

    @Override
    public ArrayList<Log> selectByID(String id) {
        return null;
    }

    @Override
    public ArrayList<Log> selectByConditon(String condition) {
        return null;
    }
}
