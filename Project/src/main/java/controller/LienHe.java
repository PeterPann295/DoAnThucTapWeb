package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ContactDAO;
import model.Contact;
import utils.Email;

/**
 * Servlet implementation class LienHe
 */
public class LienHe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LienHe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String hanhDong = request.getParameter("hanhDong");
			if(hanhDong.equals("them")) {
				themPhanHoi(request, response);
			}else if(hanhDong.equals("phanHoi")) {
				phanHoi(request, response);
			}else if(hanhDong.equals("guiMail")) {
				guiMail(request, response);
			}
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

	private void themPhanHoi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String content = request.getParameter("content");

		Contact contact = new Contact(name, phone, email, content);
		ContactDAO dao = new ContactDAO();
		dao.insert(contact);
		request.setAttribute("respone", "Bạn đã gửi thành công!");
		request.getRequestDispatcher("/lienHe.jsp").forward(request, response);
	}
	private void phanHoi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contactID = request.getParameter("contactID");
		ContactDAO dao = new ContactDAO();
		Contact contact = dao.selectByID(contactID).get(0);
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/phanHoiAdmin.jsp").forward(request, response);
	}
	private void guiMail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contactID = request.getParameter("contactID");
		String tieuDe = request.getParameter("tieuDe");
		String noiDung = request.getParameter("noiDung");
		ContactDAO dao = new ContactDAO();
		Contact contact = dao.selectByID(contactID).get(0);
		Email email = new Email();
		email.sendEmail(contact.getEmail(), tieuDe, noiDung);
		dao.delete(contact);
		request.getRequestDispatcher("/lienHeAdmin.jsp").forward(request, response);
	}

}
