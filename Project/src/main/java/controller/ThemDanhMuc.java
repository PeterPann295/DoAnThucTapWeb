package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CategoryDAO;
import database.ParentCategoryDAO;
import model.Category;
import model.ParentCategory;

/**
 * Servlet implementation class ThemDanhMuc
 */
public class ThemDanhMuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDanhMuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryID = request.getParameter("categoryID");
		String categoryName = request.getParameter("categoryName");
		
		String[] categorySelect = request.getParameterValues("category");
		
		String parentCateID = categorySelect[0];
		System.out.println(" result: " + parentCateID);
		
		ParentCategoryDAO pcd = new ParentCategoryDAO();
		ParentCategory parent = pcd.selectByID(parentCateID).get(0);
		Category category = new Category(categoryID, categoryName, parent);
		CategoryDAO cateDAO = new CategoryDAO();
		cateDAO.insert(category);
		RequestDispatcher rd = request.getRequestDispatcher("/dashBoard.jsp");
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
