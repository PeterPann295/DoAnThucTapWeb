	package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import model.Customer;
import model.Order;
import model.ParentCategory;
import utils.JDBCUtil;

public class OrderDAO implements InterfaceDAO<Order> {

	@Override
	public boolean insert(Order t) {
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "insert into Orders values (?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getOrderID());
			pst.setInt(2, t.getCustomerID().getId());
			pst.setDate(3, t.getOrderDate());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "Select * from Orders";

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			CustomerDAO cusDAO = new CustomerDAO();
			while (rs.next()) {
				String orderID = rs.getNString(1);
				int idCus = rs.getInt(2);
				Date date = rs.getDate(3);
				Order o = new Order(orderID, cusDAO.selectByID(String.valueOf(idCus)).get(0), date);
				orders.add(o);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public ArrayList<Order> selectByID(String id) {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "Select * from Orders where orderID = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			CustomerDAO cusDAO = new CustomerDAO();
			while (rs.next()) {
				String orderID = rs.getNString(1);
				int idCus = rs.getInt(2);
				Date date = rs.getDate(3);
				Order o = new Order(orderID, cusDAO.selectByID(String.valueOf(idCus)).get(0), date);
				orders.add(o);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public ArrayList<Order> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> selectByCustomerID(Customer cus) {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "Select * from Orders where CustomerID=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cus.getId());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String orderID = rs.getNString(1);
				Date date = rs.getDate(3);
				Order o = new Order(orderID, cus, date);
				orders.add(o);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	 public Map<String, Double> revenueLast7Days() {
	        Map<String, Double> result = new TreeMap<>(); // Sử dụng TreeMap thay vì HashMap để sắp xếp theo key

	        try {
	            Connection con = JDBCUtil.getConnection();

	            String sql = "SELECT\r\n Top 7"
	            		+ "    DATEADD(day, DATEDIFF(day, 0, orderDate), 0) AS OrderDay,\r\n"
	            		+ "     SUM(CASE WHEN p.discountID IS NOT NULL THEN oi.quantity * (p.price - d. discountPercentage / 100.0 * p.price)\r\n"
	            		+ "             ELSE oi.quantity * p.price END) AS TotalRe\r\n"
	            		+ "FROM\r\n"
	            		+ "    Orders o\r\n"
	            		+ "    JOIN OrderItems oi ON o.orderID = oi.orderID\r\n"
	            		+ "    JOIN Products p ON oi.productID = p.productID\r\n"
	            		+ "	LEFT JOIN Discounts d ON p.discountID = d.discountID\r\n"
	            		+ "\r\n"
	            		+ "GROUP BY\r\n"
	            		+ "    DATEADD(day, DATEDIFF(day, 0, orderDate), 0)\r\n"
	            		+ "ORDER BY\r\n"
	            		+ "    OrderDay Desc;";

	            PreparedStatement pst = con.prepareStatement(sql);

	            ResultSet rs = pst.executeQuery();
	            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	            while (rs.next()) {
	                Date day = rs.getDate(1);
	                double total = rs.getDouble(2);
	                String dateString = dateFormat.format(day);
	                result.put(dateString, total);
	            }
	            con.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	 
	 public Map<String, Double> revenueYears() {
	        Map<String, Double> result = new TreeMap<>(); // Sử dụng TreeMap thay vì HashMap để sắp xếp theo key

	        try {
	            Connection con = JDBCUtil.getConnection();

	            String sql = "SELECT\r\n"
	            		+ "    YEAR(orderDate) AS OrderYear,\r\n"
	            		+ "    SUM(\r\n"
	            		+ "        CASE\r\n"
	            		+ "            WHEN p.discountID IS NOT NULL THEN oi.quantity * (p.price - d.discountPercentage / 100.0 * p.price)\r\n"
	            		+ "            ELSE oi.quantity * p.price\r\n"
	            		+ "        END\r\n"
	            		+ "    ) AS TotalRevenue\r\n"
	            		+ "FROM\r\n"
	            		+ "    Orders o\r\n"
	            		+ "    JOIN OrderItems oi ON o.orderID = oi.orderID\r\n"
	            		+ "    JOIN Products p ON oi.productID = p.productID\r\n"
	            		+ "    LEFT JOIN Discounts d ON p.discountID = d.discountID\r\n"
	            		+ "GROUP BY\r\n"
	            		+ "    YEAR(orderDate)\r\n"
	            		+ "ORDER BY\r\n"
	            		+ "    OrderYear";

	            PreparedStatement pst = con.prepareStatement(sql);

	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	                int day = rs.getInt(1);
	                double total = rs.getDouble(2);
	                String dateString = String.valueOf(day);
	                result.put(dateString, total);
	            }
	            con.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	 
	 public double totalRevenue() {
		 double result = 0;
		 try {
				Connection con = JDBCUtil.getConnection();

				String sql = "SELECT\r\n"
						+ "    SUM(CASE WHEN p.discountID IS NOT NULL THEN oi.quantity * (p.price - d.discountPercentage / 100.0 * p.price)\r\n"
						+ "             ELSE oi.quantity * p.price END) AS TotalRevenue\r\n"
						+ "FROM\r\n"
						+ "    OrderItems oi\r\n"
						+ "    JOIN Products p ON oi.productID = p.productID\r\n"
						+ "    LEFT JOIN Discounts d ON p.discountID = d.discountID;";

				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					result = rs.getDouble(1);
				}
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return result;
	 }

	public Map<String, Integer> orderStatus() {
		Map<String, Integer> result = new HashMap<>();

		try {
			Connection con = JDBCUtil.getConnection();
			// Cập nhật truy vấn để join với bảng Status và sử dụng statusID
			String sql = "SELECT s.statusName, COUNT(*) FROM Orders o JOIN Status s ON o.statusID = s.statusID GROUP BY s.statusName;";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String statusName = rs.getString("statusName"); // Giả sử cột trong bảng Status là statusName
				int count = rs.getInt(2);
				result.put(statusName, count);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	 
	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		// in ra trạng thái orderStatus
		System.out.println(dao.orderStatus());

	}
}
