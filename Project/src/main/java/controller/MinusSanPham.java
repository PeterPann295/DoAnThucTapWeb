package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.OrderItem;

/**
 * Servlet implementation class MinusSanPham
 */
public class MinusSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MinusSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productID = request.getParameter("product");

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<String, OrderItem> cartItems = (Map<String, OrderItem>) obj;
		Iterator<Map.Entry<String, OrderItem>> iterator = cartItems.entrySet().iterator();
		int cartSize = (int) session.getAttribute("cartSize");
		Order order = (Order) session.getAttribute("order");
		while (iterator.hasNext()) {
		    Map.Entry<String, OrderItem> entry = iterator.next();
		    OrderItem orderItem = entry.getValue();

		    if (orderItem.getProductID().getProductID().equalsIgnoreCase(productID)) {
		        if (orderItem.getQuantity() > 0) {
		            orderItem.setQuantity(orderItem.getQuantity() - 1);
		            cartSize -= 1;
		            if (orderItem.getQuantity() == 0) {
		                iterator.remove();
		                order.getOrderItems().remove(orderItem);// Sử dụng iterator để loại bỏ một cách an toàn
		            }
		        }
		    }
		}
		session.setAttribute("order", order);
		session.setAttribute("cartSize", cartSize);
		request.getRequestDispatcher("GioHang").forward(request, response);
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
