package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ParentCategory;
import utils.JDBCUtil;

public class ParentCategoryDAO implements InterfaceDAO<ParentCategory>{

	@Override
	public boolean insert(ParentCategory t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "insert into ParentCategories values (?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getParentCategoryID());
			pst.setNString(2, t.getName());
			pst.setString(3, t.getImageURL());
			
			pst.executeUpdate();
			con.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ParentCategory t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ParentCategory t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ParentCategory> selectAll() {
		ArrayList<ParentCategory> categories = new ArrayList<ParentCategory>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from ParentCategories";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				String url = rs.getNString(3);
				ParentCategory cate = new ParentCategory(categoryID, name, url);
				categories.add(cate);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public ArrayList<ParentCategory> selectByID(String id) {
		ArrayList<ParentCategory> categories = new ArrayList<ParentCategory>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from ParentCategories Where parentCategoryID=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				String url = rs.getNString(3);
				ParentCategory cate = new ParentCategory(categoryID, name, url);
				categories.add(cate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public ArrayList<ParentCategory> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		ParentCategoryDAO dao  = new ParentCategoryDAO();
		ArrayList<ParentCategory> list = dao.selectAll();
		for (ParentCategory parentCategory : list) {
			System.out.println(parentCategory);
		}
	}
	

}
