package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;
import utils.Email;
import utils.StringFilter;

/**
 * Servlet implementation class QuenMatKhau
 */
public class QuenMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuenMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.checkUsernamePassword(username);
		String url = "/quenMatKhauThanhCong.jsp";
		if(customer == null ) {
			url="/quenMatKhau.jsp";
			request.setAttribute("error", "Tên đăng nhập không tồn tại");
		}
		Email.sendEmaiQuenMatKhau(customer);
		String email = StringFilter.maskEmail(customer.getEmail());
		request.setAttribute("email", email);
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
