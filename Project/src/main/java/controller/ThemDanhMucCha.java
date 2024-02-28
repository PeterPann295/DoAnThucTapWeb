package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.ParentCategoryDAO;
import model.ParentCategory;

/**
 * Servlet implementation class ThemDanhMucCha
 */
@MultipartConfig
public class ThemDanhMucCha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDanhMucCha() {
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
		
		String parentCateID = request.getParameter("parentCateID");
		String parentCateName = request.getParameter("parentCateName");
		String fileName = "";
		try {
			Part part = request.getPart("imgCate");

			String realPath = request.getServletContext().getRealPath("/images/category");
			fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			part.write(realPath + "/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String image = "images/category/" + fileName;
		
		ParentCategory parentCate = new ParentCategory(parentCateID, parentCateName, image);
		ParentCategoryDAO dao = new ParentCategoryDAO();
		dao.insert(parentCate);
		RequestDispatcher rd = request.getRequestDispatcher("/danhMucLonAdmin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
