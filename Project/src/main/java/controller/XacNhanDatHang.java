package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.OrderDAO;
import database.OrderItemDAO;
import model.Order;
import model.OrderItem;
import utils.Email;
import utils.StringFilter;

/**
 * Servlet implementation class XacNhanDatHang
 */
public class XacNhanDatHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDatHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insert(order);
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		for (OrderItem o : order.getOrderItems()) {
			if(o.getQuantity() <=0) {
				order.getOrderItems().remove(o);
			}
			orderItemDAO.insert(o);
		}
		String content = StringFilter.xacThucDonHang(order);
		Email.sendEmailXacNhanDonHang(order);
		session.removeAttribute("cart");
		session.removeAttribute("order");
		session.removeAttribute("cartSize");
		session.removeAttribute("totalPrice");
		request.getRequestDispatcher("/xacNhanDonHangThanhCong.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
