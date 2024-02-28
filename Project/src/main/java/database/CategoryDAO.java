package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;
import model.ParentCategory;
import utils.JDBCUtil;

public class CategoryDAO implements InterfaceDAO<Category> {

	@Override
	public boolean insert(Category t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "insert into Categories values (?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getCategoryID());
			pst.setNString(2, t.getNameCategory());
			pst.setNString(3, t.getParent().getParentCategoryID());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Categories";
			
			PreparedStatement pst = con.prepareStatement(sql);
						
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				String idParent = rs.getNString(3);
				ParentCategoryDAO parentDAO = new ParentCategoryDAO();
				
				ParentCategory parent = parentDAO.selectByID(idParent).get(0);
				
				Category cate = new Category(categoryID, name, parent);
				categories.add(cate);
			}
			JDBCUtil.closeConnection(con);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public ArrayList<Category> selectByID(String id) {
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Categories Where CategoryID=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				String idParent = rs.getNString(3);
				
				ParentCategoryDAO parentDAO = new ParentCategoryDAO();
				
				ParentCategory parent = parentDAO.selectByID(idParent).get(0);
				
				Category cate = new Category(categoryID, name, parent);
				categories.add(cate);
			}
			JDBCUtil.closeConnection(con);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public ArrayList<Category> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Category> selectByParentID(String parentID) {
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Categories Where parentCategoryID=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, parentID);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				String idParent = rs.getNString(3);
				
				ParentCategoryDAO parentDAO = new ParentCategoryDAO();
				
				ParentCategory parent = parentDAO.selectByID(idParent).get(0);
				
				Category cate = new Category(categoryID, name, parent);
				categories.add(cate);
			}
			JDBCUtil.closeConnection(con);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();
		ArrayList<Category> list = dao.selectByParentID("DM01");
		System.out.println(list.size());
		for (Category category : list) {
			System.out.println(category.getNameCategory());
		}
	}
}
