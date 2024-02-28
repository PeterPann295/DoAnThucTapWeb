package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;
import utils.StringEncryption;

/**
 * Servlet implementation class DangKiTaiKhoanAdmin
 */
public class DangKiTaiKhoanAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKiTaiKhoanAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		String fullName = request.getParameter("full-name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		username = (username.equals("null"))?"" : username;
		password = (password.equals("null"))?"" : password;
		fullName = (fullName.equals("null"))?"" : fullName;
		phone = (phone.equals("null"))?"" : phone;
		email  = (email.equals("null"))?"" : email;
		address = (address.equals("null"))?"" :address;
		
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("confirm-password", confirmPassword);
		request.setAttribute("fullName", fullName);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("address", address);
		
		String url = "";

		CustomerDAO cd = new CustomerDAO();
		Customer customer = cd.checkUsernamePassword(username);
		boolean error = false;
		if (customer != null) {
			if (username.equals(customer.getUsername())) {
				request.setAttribute("err_username", "Tên đăng nhập đã tồn tại, vui lòng chọn tên khác");
				url = "/themAdmin.jsp";
				error = true;
			}

		}
		if (!password.equals(confirmPassword)) {
			request.setAttribute("err_password", "Nhập mật khẩu không khớp");
			url = "/themAdmin.jsp";
			error = true;
		}
		if (!error) {
			Customer cus = new Customer(username, StringEncryption.encryptString(password), fullName, phone, email, address);
			cus.setRole(true);
			cd.insert(cus);
			url = "/nguoiDungLaAdminAdmin.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
