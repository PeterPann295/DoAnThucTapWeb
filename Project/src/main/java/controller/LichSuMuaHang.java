package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.OrderDAO;
import database.OrderItemDAO;
import model.Customer;
import model.Order;

/**
 * Servlet implementation class LichSuMuaHang
 */
public class LichSuMuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuMuaHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		OrderDAO orderDAO = new OrderDAO();
		ArrayList<Order> orders = orderDAO.selectByCustomerID(customer);
		if(orders.size() == 0) {
			request.setAttribute("emtyOrder", "Bạn chưa có đặt mua đơn hàng nào!");
			request.getRequestDispatcher("/lichSuMuaHang.jsp").forward(request, response);;
		} else {
			OrderItemDAO orderItemDAO = new OrderItemDAO();
			for (Order order : orders) {
				order.setOrderItems(orderItemDAO.selectByOrderID(order));
			}
			session.setAttribute("historyOrder", orders);
			request.getRequestDispatcher("/lichSuMuaHang.jsp").forward(request, response);

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
