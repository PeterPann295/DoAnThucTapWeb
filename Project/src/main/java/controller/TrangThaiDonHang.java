package controller;

import java.io.IOException;
import java.util.List;
import model.Status;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.StatusDAO;

public class TrangThaiDonHang extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            response.sendRedirect("dangNhap.jsp");
            return;
        }
        // Lấy danh sách trạng thái đơn hàng
        StatusDAO statusDAO = new StatusDAO();
        List<Status> statusList = statusDAO.getAllStatus();
        // Đưa danh sách trạng thái đơn hàng vào request
        request.setAttribute("statusList", statusList);

        // Xử lý cập nhật trạng thái đơn hàng
        String orderID = request.getParameter("orderID");
        String statusID = request.getParameter("statusID");
        // Nếu orderID và statusID không rỗng thì cập nhật trạng thái đơn hàng
        if (orderID != null && statusID != null) {
            statusDAO.updateStatus(orderID, statusID);
        }

        request.getRequestDispatcher("trangThaiDonHang.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý hủy đơn hàng
        String orderID = request.getParameter("orderID");
        // Nếu orderID không rỗng thì tìm trạng thái "Đã hủy"
        if (orderID != null) {
            StatusDAO statusDAO = new StatusDAO();
            List<Status> statusList = statusDAO.getAllStatus();
            String cancelledStatusID = null;
            // Tìm trạng thái "Đã hủy"
            for (Status status : statusList) {
                if ("Đã hủy".equals(status.getStatusName())) {
                    cancelledStatusID = status.getStatusID();
                    break;
                }
            }
            // Nếu tìm thấy trạng thái "Đã hủy" thì cập nhật trạng thái đơn hàng
            if (cancelledStatusID != null) {
                statusDAO.updateStatus(orderID, cancelledStatusID);
            }
        }
        doGet(request, response);
    }
}