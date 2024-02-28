package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderItem;

/**
 * Servlet implementation class GioHang
 */
public class GioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("customer") == null) {
			request.getRequestDispatcher("/dangNhap.jsp").forward(request, response);
			return;
		}
		Object obj = session.getAttribute("cart");
		if(obj==null) {
			request.setAttribute("cartEmpty", "Bạn chưa có sản phẩm nào trong giỏ hàng");
			request.getRequestDispatcher("/gioHang.jsp").forward(request, response);
		} else {
			Map<String, OrderItem> cartItems = (Map<String, OrderItem>) obj;
			
			double totalPrice = 0;
			List<OrderItem> orderList = new ArrayList<>();
			for (OrderItem orderItem : cartItems.values()) {
				totalPrice += orderItem.getQuantity() * orderItem.getProductID().getFinalPrice();
				orderList.add(orderItem);
			}
			session.setAttribute("totalPrice", totalPrice);
			request.setAttribute("cartOrder", orderList);
			request.getRequestDispatcher("/gioHang.jsp").forward(request, response);

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
