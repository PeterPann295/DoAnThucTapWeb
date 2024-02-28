package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderItem;

/**
 * Servlet implementation class PlusSanPham
 */
public class PlusSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productID = request.getParameter("product");

		  HttpSession session = request.getSession();
		    Object obj = session.getAttribute("cart");
		    Map<String, OrderItem> cartItems = (Map<String, OrderItem>) obj;
			int cartSize = (int) session.getAttribute("cartSize");

		    for (OrderItem orderItem : cartItems.values()) {
		    	if(orderItem.getProductID().getProductID().equalsIgnoreCase(productID)) {
		    		if(orderItem.getQuantity() > 0) {
		    			orderItem.setQuantity(orderItem.getQuantity() + 1);
			            cartSize += 1;

		    		}
		    	}
		    }
			session.setAttribute("cartSize", cartSize);

		    request.getRequestDispatcher("GioHang").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
