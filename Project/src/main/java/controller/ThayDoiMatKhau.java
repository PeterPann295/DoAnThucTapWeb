package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customer;
import utils.StringEncryption;

/**
 * Servlet implementation class ThayDoiMatKhau
 */
public class ThayDoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThayDoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		String newPassword = (String) request.getParameter("new-password");
		String confirmPassword = (String) request.getParameter("confirm-newPassword");
		String url = "/thayDoiMatKhauThanhCong.jsp";
		if(!newPassword.equals(confirmPassword)) {
			request.setAttribute("error", "Nhập lại mật khẩu không khớp, vui lòng nhập lại.");
			url = "/thayDoiMatKhau.jsp";
		}
		customer.setPassword(StringEncryption.encryptString(newPassword));
		CustomerDAO dao = new CustomerDAO();
		dao.update(customer);
		session.invalidate();
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
