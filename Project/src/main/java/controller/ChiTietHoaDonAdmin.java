package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OrderDAO;
import database.OrderItemDAO;
import model.Order;

/**
 * Servlet implementation class ChiTietHoaDonAdmin
 */
public class ChiTietHoaDonAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietHoaDonAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderID = request.getParameter("orderID");
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.selectByID(orderID).get(0);
		OrderItemDAO itemDAO = new OrderItemDAO();
		order.setOrderItems(itemDAO.selectByOrderID(order));
		request.setAttribute("orderDetail", order);
		request.getRequestDispatcher("/chiTietHoaDonAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
