package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;
import utils.StringEncryption;

/**
 * Servlet implementation class DangKiTaiKhoan
 */
public class DangKiTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKiTaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		username = (username.equals("null")) ? "" : username;
		password = (password.equals("null")) ? "" : password;
		fullName = (fullName.equals("null")) ? "" : fullName;
		phone = (phone.equals("null")) ? "" : phone;
		email = (email.equals("null")) ? "" : email;
		address = (address.equals("null")) ? "" : address;

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
				request.setAttribute("err_username", "Tên Đăng Nhập Đã Tồn Tại, Vui Lòng Chọn Tên Đăng Nhập Khác");
				url = "/dangKiTaiKhoan.jsp";
				error = true;
			}

		}
		if (!password.equals(confirmPassword)) {
			request.setAttribute("err_password", "Nhập Mật Khẩu Không Khớp");
			url = "/dangKiTaiKhoan.jsp";
			error = true;
		}

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(email);

		if (!emailMatcher.matches()) {
			error = true;
			url = "/dangKiTaiKhoan.jsp";
			request.setAttribute("err_email", "Câu trúc của email chưa đúng!");
		}

		// Kiểm tra số diện thoại
		Pattern soDienThoaiPattern = Pattern.compile("\\d{10}");
		Matcher soDienThoaiMatcher = soDienThoaiPattern.matcher(phone);
		if (!soDienThoaiMatcher.matches()) {
			error = true;
			url = "/dangKiTaiKhoan.jsp";
			request.setAttribute("err_phone", "Số điện thoại bao gồm 10 ký tự!");
		}
		if(username.length() < 6) {
			error = true;
			url = "/dangKiTaiKhoan.jsp";
			request.setAttribute("err_username", "Tên đăng nhập phải từ 6 kí tự");
		}
		if(password.length() < 6) {
			error = true;
			url = "/dangKiTaiKhoan.jsp";
			request.setAttribute("err_password", "Mật khẩu tối thiểu 6 kí tự");
		}
		if (!error) {
			Customer cus = new Customer(username, StringEncryption.encryptString(password), fullName, phone, email, address);
			cd.insert(cus);
			url = "/dangKiThanhCong.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
