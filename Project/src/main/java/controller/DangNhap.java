package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customer;
import utils.StringEncryption;


/**
 * Servlet implementation class DangNhap
 */
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		CustomerDAO cd = new CustomerDAO();
		Customer cus = cd.checkLogin(username, StringEncryption.encryptString(password));
		
		String url = "";
		boolean error = false;
		HttpSession session = null;
		if(cus != null) {
			session = request.getSession();
			session.setAttribute("customer", cus);
			if(cus.isRole()) {
				url = "/dashBoard.jsp";
			}else {
				url="/trangChu.jsp";
			}
			
		}else {
			error = true;
			request.setAttribute("error_login", "Tên đăng nhập hoặc mật khẩu không đúng!");
		}
		
		
		
		if(error) {
			url="/dangNhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
