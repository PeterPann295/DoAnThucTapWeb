package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import database.OrderDAO;

/**
 * Servlet implementation class BieuDoDoanhThuNam
 */
public class BieuDoDoanhThuNam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BieuDoDoanhThuNam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Đây là nơi bạn sẽ lấy dữ liệu từ nguồn của mình (cơ sở dữ liệu, file, API khác, vv.)
            // Ví dụ: lấy nhãn và dữ liệu từ cơ sở dữ liệu
            OrderDAO dao = new OrderDAO();
            Map<String, Double> dataMap = dao.revenueYears();
            
            // Tách nhãn và dữ liệu từ Map
            List<String> labels = new ArrayList<>(dataMap.keySet());
            List<Double> data = new ArrayList<>(dataMap.values());
            double total = 0;
            for (Double d : data) {
				total+= d;
			}
            request.setAttribute("dashBoard", "Doanh thu của 7 ngày gần nhất : " + total);
            // Tạo một đối tượng JSON chứa nhãn và dữ liệu
            JsonObject jsonData = new JsonObject();
            jsonData.addProperty("labels", new Gson().toJsonTree(labels).toString());
            jsonData.addProperty("data", new Gson().toJsonTree(data).toString());

            // Chuyển đối tượng JSON thành chuỗi JSON
            String jsonString = jsonData.toString();

            // Gửi chuỗi JSON về client
            out.println(jsonString);
        } catch (Exception e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        } finally {
            out.close();
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
