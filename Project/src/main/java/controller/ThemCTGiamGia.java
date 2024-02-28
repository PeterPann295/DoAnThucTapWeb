package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DiscountDAO;
import model.Discount;

/**
 * Servlet implementation class ThemCTGiamGia
 */
public class ThemCTGiamGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemCTGiamGia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String discountID = request.getParameter("discountID");
		String discountName = request.getParameter("discountName");
		String discountPercent = request.getParameter("discountPercent");
		int percent = Integer.parseInt(discountPercent);
		Discount discount = new Discount(discountID, discountName, percent);
		DiscountDAO dao = new DiscountDAO();
		dao.insert(discount);
		request.getRequestDispatcher("/chuongTrinhKhuyenMaiAdmin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
