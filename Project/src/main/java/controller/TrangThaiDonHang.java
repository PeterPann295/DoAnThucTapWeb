package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.OrderDAO;
import model.Order;

@WebServlet("/orderStatusServlet")
public class TrangThaiDonHang extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách đơn hàng từ cơ sở dữ liệu
    	HttpSession session = request.getSession();
        List<Order> orders = new ArrayList<>();
        OrderDAO orderDAO = new OrderDAO(); 
        orders = orderDAO.selectAll(); 

        // Cập nhật trạng thái của các đơn hàng
        for (Order order : orders) {
            order.updateOrderStatus(); // Cập nhật trạng thái của đơn hàng
        }

        // Chuyển danh sách đơn hàng đã được cập nhật vào request để hiển thị trên trang JSP
        request.setAttribute("historyOrder", orders);
        request.getRequestDispatcher("/trangThaiDonHang.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
