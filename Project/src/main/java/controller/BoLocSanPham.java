package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ProductDAO;
import model.Product;
import utils.StringFilter;

/**
 * Servlet implementation class BoLocSanPham
 */
public class BoLocSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoLocSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hanhDong = request.getParameter("hanhDong");

		if (hanhDong.equals("parent-category")) {
			filterParentCategory(request, response);
		} else if (hanhDong.equals("price")) {
			filterPrice(request, response);
		} else if(hanhDong.equals("category")) {
			filterCategory(request, response);
		}else if(hanhDong.equals("name")) {
			nameProduct(request, response);
		}else if(hanhDong.equals("giaGiam")) {
			priceDecrease(request, response);
		}else if(hanhDong.equals("giaTang")) {
			priceIncrease(request, response);
		}else if(hanhDong.equals("AZ")) {
			aZ(request, response);
		}else if(hanhDong.equals("ZA")) {
			zA(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void filterParentCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parentCategoryID = request.getParameter("parentCategoryID");
		String queryFilter = "Categories.parentCategoryID=" + "'" + parentCategoryID + "'";
		ProductDAO dao = new ProductDAO();
	
		ArrayList<Product> productByFilter = dao.selectByFilter(queryFilter);

		if(productByFilter.size() == 0) {
			request.setAttribute("resultFilter", "Sản Phẩm Đang Được Cập Nhật");
		}else {
			request.setAttribute("resultFilter", "Số lượng sản phẩm được tìm thấy: " + productByFilter.size());

		}
		HttpSession session = request.getSession();
		session.setAttribute("productList", productByFilter);

		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}
	private void filterCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryID = request.getParameter("category");
		String queryFilter = "Categories.categoryID=" + "'" + categoryID + "'";
		ProductDAO dao = new ProductDAO();

		ArrayList<Product> productByFilter = dao.selectByFilter(queryFilter);
		
		if(productByFilter.size() == 0) {
			request.setAttribute("resultFilter", "Sản Phẩm Đang Được Cập Nhật");
		}else {
			request.setAttribute("resultFilter", "Số lượng sản phẩm được tìm thấy: " + productByFilter.size());

		}
		
		HttpSession session = request.getSession();
		session.setAttribute("productList", productByFilter);

		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}

	private void filterPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parentCategoryID = request.getParameter("parentCategoryID");
		String[] filterPrices = request.getParameterValues("filter_Price");
		ProductDAO dao = new ProductDAO();
		String discount = request.getParameter("discount");
		String query = "";
		if(filterPrices!=null ) {
			query = filterPrices[0];
		}
		if(discount != null) {
			if(query.length() > 1) {
				query += "AND discountID in (Select discountID  from Discounts)";

			}else {
				query += "discountID in (Select discountID  from Discounts)";

			}
		}
		ArrayList<Product> productByFilter = dao.selectByFilter(query);
	
		if(productByFilter.size() == 0) {
			request.setAttribute("resultFilter", "Sản Phẩm Đang Được Cập Nhật");
		}else {
			request.setAttribute("resultFilter", "Số lượng sản phẩm được tìm thấy: " + productByFilter.size());

		}
		
		HttpSession session = request.getSession();
		session.setAttribute("productList", productByFilter);

		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}
	private void nameProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nameProduct = request.getParameter("nameProduct");
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> productByFilter = dao.selectByName(nameProduct);
		
		if(productByFilter.size() == 0) {
			request.setAttribute("resultFilter", "Sản Phẩm Đang Được Cập Nhật");
		}else {
			request.setAttribute("resultFilter", "Số lượng sản phẩm được tìm thấy: " + productByFilter.size());

		}
		
		HttpSession session = request.getSession();
		session.setAttribute("productList", productByFilter);
		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}
	private void priceDecrease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Product> productByFilter = (ArrayList<Product>) session.getAttribute("productList");
		String trang = request.getParameter("trang");
		if(trang != null) {
			ProductDAO dao = new ProductDAO();
			productByFilter = dao.selectAll();
		}
		productByFilter.sort((o1, o2) -> Double.compare(o2.getFinalPrice(), o1.getFinalPrice()));
		session.setAttribute("productList", productByFilter);
		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}
	private void priceIncrease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Product> productByFilter = (ArrayList<Product>) session.getAttribute("productList");
		String trang = request.getParameter("trang");
		if(trang != null) {
			ProductDAO dao = new ProductDAO();
			productByFilter = dao.selectAll();
		}
		productByFilter.sort((o1, o2) -> Double.compare(o1.getFinalPrice(), o2.getFinalPrice()));
		session.setAttribute("productList", productByFilter);
		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}
	private void aZ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Product> productByFilter = (ArrayList<Product>) session.getAttribute("productList");
		String trang = request.getParameter("trang");
		if(trang != null) {
			ProductDAO dao = new ProductDAO();
			productByFilter = dao.selectAll();
		}
		productByFilter.sort((o1, o2) -> o1.getNameProduct().compareTo(o2.getNameProduct()));
		session.setAttribute("productList", productByFilter);
		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}
	private void zA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Product> productByFilter = (ArrayList<Product>) session.getAttribute("productList");
		String trang = request.getParameter("trang");
		if(trang != null) {
			ProductDAO dao = new ProductDAO();
			productByFilter = dao.selectAll();
		}
		productByFilter.sort((o1, o2) -> o2.getNameProduct().compareTo(o1.getNameProduct()));
		session.setAttribute("productList", productByFilter);
		request.getRequestDispatcher("/ketQuaLocSanPham.jsp").forward(request, response);
	}

}
