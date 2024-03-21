package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;
import model.Contact;
import model.ParentCategory;
import utils.JDBCUtil;

public class ContactDAO implements InterfaceDAO<Contact>{

	@Override
	public boolean insert(Contact t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "insert into Contacts values (?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getName());
			pst.setNString(2, t.getNumberPhone());
			pst.setNString(3, t.getEmail());
			pst.setNString(4, t.getContent());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Contact t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Contact t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "delete from Contacts where contactID = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getContactId());
			return pst.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Contact> selectAll() {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Contacts";
			
			PreparedStatement pst = con.prepareStatement(sql);
						
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				contacts.add(new Contact(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5)));
			}
			JDBCUtil.closeConnection(con);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public ArrayList<Contact> selectByID(String id) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Contacts where contactID=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(id));
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				contacts.add(new Contact(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5)));
			}
			JDBCUtil.closeConnection(con);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public ArrayList<Contact> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new ContactDAO().selectAll());
	}

}
