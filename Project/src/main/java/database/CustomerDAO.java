package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import utils.JDBCUtil;

public class CustomerDAO implements InterfaceDAO<Customer> {

	@Override
	public boolean insert(Customer t) {
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "insert into Customers values (?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getUsername());
			pst.setNString(2, t.getPassword());
			pst.setNString(3, t.getNameCustomer());
			pst.setNString(4, t.getNumberPhone());
			pst.setNString(5, t.getEmail());
			pst.setNString(6, t.getAddress());
			pst.setBoolean(7, t.isRole());
			int i = pst.executeUpdate();
			if (i > 0) {
				con.close();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(Customer t) {
	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "UPDATE Customers SET password=?, nameCustomer=?, numberPhone=?, email=?, address=?, role=? WHERE username=?";
	        PreparedStatement pst = con.prepareStatement(sql);

	        pst.setNString(1, t.getPassword());
	        pst.setNString(2, t.getNameCustomer());
	        pst.setNString(3, t.getNumberPhone());
	        pst.setNString(4, t.getEmail());
	        pst.setNString(5, t.getAddress());
	        pst.setBoolean(6, t.isRole());
	        pst.setNString(7, t.getUsername());

	        int i = pst.executeUpdate();
	        if (i > 0) {
	            con.close();
	            return true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // In ra thông tin lỗi để kiểm tra và sửa lỗi
	    }
	    return false;
	}


	@Override
	public boolean delete(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		try {
			ArrayList<Customer> result = new ArrayList<Customer>();
			Connection conn = JDBCUtil.getConnection();
			String sql = "Select * from Customers";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getString(6), rs.getString(7), rs.getBoolean(8)));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Customer> selectByID(String id) {
		try {
			ArrayList<Customer> result = new ArrayList<Customer>();
			Connection conn = JDBCUtil.getConnection();
			String sql = "Select * from Customers where customerID = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(id));
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getString(6), rs.getString(7), rs.getBoolean(8)));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Customer> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	// Kiem tra tên tài khoản đã tồn tại hay chưa:
	public Customer checkUsernamePassword(String username) {
		Customer c = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Customers Where username=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String user_name = rs.getString(2);
				String password_ = rs.getString(3);
				String nameCustomer_ = rs.getString(4);
				String numberPhone_ = rs.getString(5);
				String email = rs.getString(6);
				String address = rs.getString(7);
				boolean role = rs.getBoolean(8);
				c = new Customer(id,user_name, password_, nameCustomer_, numberPhone_, email, address, role);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	// kiểm tra tài khoản với mật khẩu đúng hay không
	public Customer checkLogin(String username, String password) {
		Customer c = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Customers Where username=? and password=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String user_name = rs.getString(2);
				String password_ = rs.getString(3);
				String nameCustomer_ = rs.getString(4);
				String numberPhone_ = rs.getString(5);
				String email = rs.getString(6);
				String address = rs.getString(7);
				boolean role = rs.getBoolean(8);
				c = new Customer(id,user_name, password_, nameCustomer_, numberPhone_, email, address, role);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
	public ArrayList<Customer> selectAllAdmin() {
		try {
			ArrayList<Customer> result = new ArrayList<Customer>();
			Connection conn = JDBCUtil.getConnection();
			String sql = "Select * from Customers where role = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setBoolean(1, true);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getString(6), rs.getString(7), rs.getBoolean(8)));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Customer> top5KhachHang() {
		try {
			ArrayList<Customer> result = new ArrayList<Customer>();
			Connection conn = JDBCUtil.getConnection();
			String sql = "WITH CalculatedOrderAmount AS (\r\n"
					+ "    SELECT\r\n"
					+ "        C.customerID,\r\n"
					+ "		C.username,\r\n"
					+ "		C.password,\r\n"
					+ "        C.nameCustomer,\r\n"
					+ "		C.numberPhone,\r\n"
					+ "		C.email,\r\n"
					+ "		C.address,\r\n"
					+ "		c.role,\r\n"
					+ "        SUM(P.price * OI.quantity * (1 - ISNULL(D.discountPercentage, 0) / 100)) AS totalAmount\r\n"
					+ "    FROM\r\n"
					+ "        Customers C\r\n"
					+ "        INNER JOIN Orders O ON C.customerID = O.customerID\r\n"
					+ "        INNER JOIN OrderItems OI ON O.orderID = OI.orderID\r\n"
					+ "        INNER JOIN Products P ON OI.productID = P.productID\r\n"
					+ "        LEFT JOIN Discounts D ON P.discountID = D.discountID\r\n"
					+ "    GROUP BY\r\n"
					+ "        C.customerID, C.username,\r\n"
					+ "		C.password,\r\n"
					+ "        C.nameCustomer,\r\n"
					+ "		C.numberPhone,\r\n"
					+ "		C.email,\r\n"
					+ "		C.address,\r\n"
					+ "		c.role\r\n"
					+ ")\r\n"
					+ "SELECT TOP 5\r\n"
					+ "     customerID,\r\n"
					+ "		username,\r\n"
					+ "		password,\r\n"
					+ "       nameCustomer,\r\n"
					+ "	numberPhone,\r\n"
					+ "		email,\r\n"
					+ "		address,\r\n"
					+ "		role,\r\n"
					+ "    totalAmount\r\n"
					+ "FROM\r\n"
					+ "    CalculatedOrderAmount\r\n"
					+ "ORDER BY\r\n"
					+ "    totalAmount DESC;\r\n"
					+ "";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getString(6), rs.getString(7), rs.getBoolean(8)));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateRole(boolean role, String id) {
	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "UPDATE Customers SET role = ? where customerID = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setBoolean(1, role);
	        pst.setInt(2, Integer.parseInt(id));
	        int i = pst.executeUpdate();
	        if (i > 0) {
	            con.close();
	            return true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // In ra thông tin lỗi để kiểm tra và sửa lỗi
	    }
	    return false;
	}
	
	public double tongTienMuaHang(int id) {
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "WITH CalculatedOrderAmount AS (\r\n"
					+ "    SELECT\r\n"
					+ "          SUM(\r\n"
					+ "        CASE\r\n"
					+ "            WHEN P.discountID IS NOT NULL THEN OI.quantity * (P.price - D.discountPercentage / 100.0 * P.price)\r\n"
					+ "            ELSE OI.quantity * P.price\r\n"
					+ "        END\r\n"
					+ "    ) AS TotalRevenue\r\n"
					+ "    FROM\r\n"
					+ "        Customers C\r\n"
					+ "        INNER JOIN Orders O ON C.customerID = O.customerID\r\n"
					+ "        INNER JOIN OrderItems OI ON O.orderID = OI.orderID\r\n"
					+ "        INNER JOIN Products P ON OI.productID = P.productID\r\n"
					+ "        LEFT JOIN Discounts D ON P.discountID = D.discountID\r\n"
					+ "    WHERE\r\n"
					+ "        C.customerID = ? \r\n"
					+ "    GROUP BY\r\n"
					+ "        C.customerID, C.username, C.password,\r\n"
					+ "        C.nameCustomer, C.numberPhone, C.email, C.address, C.role\r\n"
					+ ")\r\n"
					+ "\r\n"
					+ "SELECT\r\n"
					+ "    TotalRevenue\r\n"
					+ "FROM\r\n"
					+ "    CalculatedOrderAmount";
				
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		}
	
	public static void main(String[] args) {
		CustomerDAO cus = new CustomerDAO();
//		Customer c = cus.checkLogin("chuotcon", "chuotcon");
//		System.out.println(c);
		System.out.println(cus.top5KhachHang().size());
	}

}
