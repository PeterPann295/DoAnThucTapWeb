package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ProductDAO;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;

/**
 * Servlet implementation class ThemVaoGioHang
 */
public class ThemVaoGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemVaoGioHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Customer cus = null;
		if (session != null) {
			cus = (Customer) session.getAttribute("customer");
		}

		String productID = request.getParameter("product");
		String amountRQ = request.getParameter("amount");
		int quantity = 1;
		if (amountRQ != null) {
			quantity = Integer.parseInt(amountRQ);
		}

		ProductDAO productDAO = new ProductDAO();

		Product product = productDAO.selectByID(productID).get(0);
		List<OrderItem> items = new ArrayList<OrderItem>();
		java.util.Date currentDate = new java.util.Date();
		Date sqlDate = new Date(currentDate.getTime());

		Order order;
		order = (Order) session.getAttribute("order");
		if (order == null) {
			order = new Order(cus, sqlDate, items);
		}
		Object obj = session.getAttribute("cart");
		OrderItem orderItem;
		int cartSize = 0;
		if (obj == null) {
			orderItem = new OrderItem(order, product, quantity);
			Map<String, OrderItem> map = new HashMap<String, OrderItem>();
			order.getOrderItems().add(orderItem);
			map.put(productID, orderItem);
			cartSize = quantity;
			session.setAttribute("cart", map);
		} else {
			Map<String, OrderItem> map = (Map<String, OrderItem>) obj;
			orderItem = map.get(productID);
			if (orderItem == null) {
				orderItem = new OrderItem(order, product, quantity);
				map.put(productID, orderItem);
				order.getOrderItems().add(orderItem);

			} else {
				orderItem.setQuantity(orderItem.getQuantity() + quantity);
			}

			for (OrderItem od : map.values()) {
				cartSize += od.getQuantity();
			}

			session.setAttribute("cart", map); // lưu vào session
		}
		session.setAttribute("order", order);
		session.setAttribute("cartSize", cartSize);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print("{\"cartSize\":" + cartSize + "}");
		out.flush();
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

}
