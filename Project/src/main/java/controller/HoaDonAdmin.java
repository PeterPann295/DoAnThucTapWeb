package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OrderDAO;
import database.OrderItemDAO;
import model.Order;

/**
 * Servlet implementation class HoaDonAdmin
 */
public class HoaDonAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoaDonAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO orderDAO = new OrderDAO();
		OrderItemDAO itemDAO = new OrderItemDAO();
		ArrayList<Order> orders = orderDAO.selectAll();
		if(!orders.isEmpty()) {
			for (Order order : orders) {
				order.setOrderItems(itemDAO.selectByOrderID(order));
			}
		}
		String sort = request.getParameter("sort");
		if(sort != null) {
			if(sort.equals("ngay")) {
				orders.sort(new Comparator<Order>() {

					@Override
					public int compare(Order o1, Order o2) {
						return o2.getOrderDate().compareTo(o1.getOrderDate());
					}
				});
			}else if(sort.equals("gia")) {
				orders.sort((o1, o2) -> Double.compare(o2.getTotalPrice(), o1.getTotalPrice()));

			}
		}
		request.setAttribute("hoaDon", orders);
		request.getRequestDispatcher("hoaDonAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
