package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Order;
import model.OrderItem;
import model.Product;
import utils.JDBCUtil;

public class OrderItemDAO implements InterfaceDAO<OrderItem> {

	@Override
	public boolean insert(OrderItem t) {
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "insert into OrderItems values (?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getOrderID().getOrderID());
			pst.setNString(2, t.getProductID().getProductID());
			pst.setInt(3, t.getQuantity());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(OrderItem t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderItem t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderItem> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderItem> selectByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderItem> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderItem> selectByOrderID(Order order) {
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "Select * from OrderItems where orderID=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, order.getOrderID());
			ResultSet rs = pst.executeQuery();
			ProductDAO productDAO = new ProductDAO();
			while (rs.next()) {
				String orderID = rs.getNString(1);
				String productID = rs.getNString(2);
				int quantity = rs.getInt(3);
				Product product = productDAO.selectByID(productID).get(0);

				OrderItem orderItem = new OrderItem(order, product, quantity);

				orderItems.add(orderItem);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItems;
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
	}

}
