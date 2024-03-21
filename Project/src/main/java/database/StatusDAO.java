package database;

import model.Status;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO {
    private Connection connection;

    // Cập nhật trạng thái đơn hàng theo orderID và statusID
    public boolean updateStatus(String orderID, String statusID) {
        try {
            connection = JDBCUtil.getConnection();

            // Câu lệnh cập nhật trạng thái đơn hàng
            String query = "UPDATE Orders SET statusID = ? WHERE orderID = ?";
            // Tạo PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, statusID);
            statement.setString(2, orderID);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật trạng thái đơn hàng: " + e.getMessage());
            return false;
        }
    }
    // Lấy danh sách trạng thái đơn hàng từ database
    public List<Status> getAllStatus() {
        List<Status> statusList = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String query = "SELECT * FROM Status";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Duyệt từng dòng dữ liệu trong ResultSet
            while (resultSet.next()) {
                // Tạo đối tượng Status từ dữ liệu ResultSet
                String statusID = resultSet.getString("statusID");
                String statusName = resultSet.getString("statusName");
                Status status = new Status(statusID, statusName);
                statusList.add(status);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách trạng thái đơn hàng: " + e.getMessage());
        } finally {
            // Đóng connection sau khi sử dụng xong
            JDBCUtil.closeConnection(connection);
        }
        return statusList;
    }

    public static void main(String[] args) {
        StatusDAO statusDAO = new StatusDAO();
        // Lấy danh sách trạng thái đơn hàng
        List<Status> statusList = statusDAO.getAllStatus();
        // In danh sách trạng thái đơn hàng
        for (Status status : statusList) {
            System.out.println(status);
        }
    }

}