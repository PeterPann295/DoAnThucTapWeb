package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.CategoryDAO;
import database.DiscountDAO;
import database.ProductDAO;
import model.Category;
import model.Discount;
import model.Product;


/**
 * Servlet implementation class ThemSanPham
 */
@MultipartConfig
public class ThemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPham() {
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
		
		String fileName = "";
		String productID = request.getParameter("productID");
		String nameProduct = request.getParameter("productName");
		String description = request.getParameter("description");
		String pricePara = request.getParameter("price");
		productID = (productID.equals("null")) ? "" : productID;
		nameProduct = (nameProduct.equals("null")) ? "" : nameProduct;
		description = (description.equals("null")) ? "" : description;
		pricePara = (pricePara.equals("null")) ? "" : pricePara;

		request.setAttribute("productID", productID);
		request.setAttribute("nameProduct", nameProduct);
		request.setAttribute("description",description);
		request.setAttribute("price", pricePara );

		

		ProductDAO pd = new ProductDAO();
		if(!pd.selectByID(productID).isEmpty()) {
			request.setAttribute("err_productID", "Mã Sản Phẩm Đã Tồn Tại");
			request.getRequestDispatcher("/themSanPhamAdmin.jsp").forward(request, response);
			return;
		}
		
		if(Double.parseDouble(pricePara) <= 0) {
			request.setAttribute("err_price", "Giá Sản Phẩm Phải Lớn Hơn 0");
			request.getRequestDispatcher("/themSanPhamAdmin.jsp").forward(request, response);
			return;
		}
		
		try {
			Part part = request.getPart("imgProduct");
			String realPath = request.getServletContext().getRealPath("/images/product");
			fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));

			}

			part.write(realPath + "/" + fileName);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		String image = "images/product/" + fileName;
		String[] category = request.getParameterValues("category");
		String[] discounts = request.getParameterValues("discount");
		
		String categoryID = category[0];
		String discountID = discounts[0];
		System.out.println("Discount ID: "+discountID);
		double price = Double.parseDouble(pricePara);
		
		String unit = request.getParameter("unit");
		
		String[] availables = request.getParameterValues("availables");
		boolean available = false;
		if(availables[0].equals("true")) {
			available = true;
		}
		
		CategoryDAO categoryDAO = new CategoryDAO();
		Category cate = categoryDAO.selectByID(categoryID).get(0);
		Product product = new Product(productID, nameProduct, description, price, image, cate, unit, available);
		if(!discountID.equals("none")) {
			DiscountDAO discountDAO = new DiscountDAO();
			Discount discount = discountDAO.selectByID(discountID).get(0);
			product.setDiscount(discount);
		}
		System.out.println(product);
		pd.insert(product);
		request.getRequestDispatcher("/sanPhamAdmin.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
