package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import model.Discount;
import model.Product;
import utils.JDBCUtil;

public class ProductDAO implements InterfaceDAO<Product> {

	@Override
	public boolean insert(Product t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Insert into Products values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setNString(1, t.getProductID());
			pst.setNString(2, t.getNameProduct());
			pst.setNString(3, t.getDesription());
			pst.setNString(4, String.valueOf(t.getPrice()));
			pst.setNString(5, t.getImageURL());
			pst.setNString(6, t.getCategoryID().getCategoryID());
			if (t.getDiscount() != null) {
				pst.setNString(7, t.getDiscount().getDiscountID());
			} else {
				pst.setNString(7, null);
			}
			pst.setNString(8, t.getUnit());
			pst.setBoolean(9, t.isAvailable());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Update Products set productID=?, nameProduct=?, description = ?, price=?, imageURL=?, categoryID=?, discountID=?, unit=?, available=? where productID = ?";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setNString(1, t.getProductID());
			pst.setNString(2, t.getNameProduct());
			pst.setNString(3, t.getDesription());
			pst.setNString(4, String.valueOf(t.getPrice()));
			pst.setNString(5, t.getImageURL());
			pst.setNString(6, t.getCategoryID().getCategoryID());
			if (t.getDiscount() != null) {
				pst.setNString(7, t.getDiscount().getDiscountID());
			} else {
				pst.setNString(7, null);
			}
			pst.setNString(8, t.getUnit());
			pst.setBoolean(9, t.isAvailable());
			pst.setNString(10, t.getProductID());

			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product t) {
		try {
			String sql = "Delete from Products where productID = ?";
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getProductID());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Products";
			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);

				if (!available)
					break;

				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(id, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);

			}
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ArrayList<Product> selectByID(String id) {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Products where productID=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String idProduct = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);

				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);
				if (!available)
					break;

				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(idProduct, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ArrayList<Product> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> selectTop10HasDiscount() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select Top 10 * \r\n" + "from Products\r\n"
					+ "where discountID in (select discountID from Discounts)";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String idProduct = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);
				if (!available)
					continue;
				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(idProduct, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);

			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public ArrayList<Product> selectAllHasDiscount() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * \r\n" + "from Products\r\n"
					+ "where discountID in (select discountID from Discounts)";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String idProduct = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);
				if (!available)
					continue;
				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(idProduct, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);

			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public ArrayList<Product> selectAllProductNew() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select Top 10 * \r\n" + "from Products\r\n" + "Order By productID desc";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String idProduct = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);
				if (!available)
					continue;
				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(idProduct, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public ArrayList<Product> selectByFilter(String filter) {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT Products.productID, Products.nameProduct, Products.description, Products.price, Products.imageURL, Products.categoryID, Products.discountID, Products.unit, Products.available \r\n"
					+ "FROM Products\r\n" + "JOIN Categories ON Products.categoryID = Categories.categoryID\r\n"
					+ "WHERE " + filter + "";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String idProduct = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);
				if (!available)
					continue;
				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(idProduct, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			products = selectAll();
		}
		return products;
	}

	public ArrayList<Product> selectTop5ProductRelate(Product product) {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select Top 5 * from Products where categoryID=? and productID != ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, product.getCategoryID().getCategoryID());
			pst.setString(2, product.getProductID());
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String idProduct = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);

				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);
				if (!available)
					break;

				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(idProduct, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public ArrayList<Product> selectByName(String nameProduct) {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Products where nameProduct like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + nameProduct + "%");
			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);

				if (!available)
					break;

				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(id, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);

			}
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public ArrayList<Product> selectTop5BestSeller() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT TOP 5\r\n" + "    P.productID,\r\n" + "    P.nameProduct,\r\n"
					+ "    P.description,\r\n" + "    P.price,\r\n" + "	p.imageURL,\r\n" + "	p.categoryID,\r\n"
					+ "	p.discountID,\r\n" + "    P.unit,\r\n" + "	p.available,\r\n"
					+ "    SUM(OI.quantity) AS totalQuantitySold\r\n" + "FROM\r\n" + "    Products P\r\n" + "JOIN\r\n"
					+ "    OrderItems OI ON P.productID = OI.productID\r\n" + "JOIN\r\n"
					+ "    Orders O ON OI.orderID = O.orderID\r\n" + "GROUP BY\r\n" + "    P.productID,\r\n"
					+ "    P.nameProduct,\r\n" + "    P.description,\r\n" + "    P.price,\r\n" + "	p.imageURL,\r\n"
					+ "	p.categoryID,\r\n" + "	p.discountID,\r\n" + "    P.unit,\r\n" + "	p.available\r\n"
					+ "ORDER BY\r\n" + "    totalQuantitySold DESC;";
			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			CategoryDAO cado = new CategoryDAO();
			while (rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				String discountID = rs.getNString(7);
				String unit = rs.getNString(8);
				boolean available = rs.getBoolean(9);

				if (!available)
					break;

				Category c = cado.selectByID(cateID).get(0);

				Product p = new Product(id, name, description, price, img, c, unit, available);
				if (discountID != null) {
					DiscountDAO disDAO = new DiscountDAO();
					Discount discount = disDAO.selectByID(discountID).get(0);
					p.setDiscount(discount);
				}
				products.add(p);

			}
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public int tongSoBanDuoc(String productID) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT\r\n" + "    SUM(OI.quantity) AS totalQuantitySold\r\n" + "FROM\r\n"
					+ "    Products P\r\n" + "JOIN\r\n" + "    OrderItems OI ON P.productID = OI.productID\r\n"
					+ "JOIN\r\n" + "    Orders O ON OI.orderID = O.orderID\r\n" + "WHERE\r\n"
					+ "    P.productID = ?\r\n" + // Use parameterized query
					"GROUP BY\r\n" + "    P.productID,\r\n" + "    P.nameProduct;";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, productID); // Set the parameter value
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public static void main(String[] args) {

		ProductDAO dao = new ProductDAO();
		System.out.println(dao.selectByName("bò").size());
	}
}
