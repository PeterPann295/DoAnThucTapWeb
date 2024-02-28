package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Discount;
import utils.JDBCUtil;

public class DiscountDAO implements InterfaceDAO<Discount>{

	@Override
	public boolean insert(Discount t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "insert into Discounts values (?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getDiscountID());
			pst.setNString(2, t.getNameDiscount());
			pst.setDouble(3, t.getPercent());
			
			pst.executeUpdate();
			con.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Discount t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Discount t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Discount> selectAll() {
		ArrayList<Discount> discount = new ArrayList<Discount>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Discounts";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String discountID = rs.getNString(1);
				String name = rs.getNString(2);
				int percent = rs.getInt(3);
				Discount cate = new Discount(discountID,name,percent);
				discount.add(cate);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return discount;
	}

	@Override
	public ArrayList<Discount> selectByID(String id) {
		ArrayList<Discount> discount = new ArrayList<Discount>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Discounts where discountID=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String discountID = rs.getNString(1);
				String name = rs.getNString(2);
				int percent = rs.getInt(3);
				Discount cate = new Discount(discountID,name,percent);
				discount.add(cate);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return discount;
	}

	@Override
	public ArrayList<Discount> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		DiscountDAO dao = new DiscountDAO();
		System.out.println(dao.selectAll().size());
	}

}
