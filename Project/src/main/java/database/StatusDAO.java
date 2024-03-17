package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO {
    private Connection connection;

    public StatusDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean updateOrderStatus(String orderID, String newStatus) {
        String query = "UPDATE Orders SET status = ? WHERE orderID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newStatus);
            statement.setString(2, orderID);

            int rowsUpdated = statement.executeUpdate();

            // Kiểm tra xem có bao nhiêu dòng đã được cập nhật
            if (rowsUpdated > 0) {
                System.out.println("Trạng thái của đơn hàng đã được cập nhật thành công.");
                return true;
            } else {
                System.out.println("Không có đơn hàng nào được cập nhật.");
                return false; // Trả về false nếu không có dòng nào được cập nhật
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật trạng thái của đơn hàng: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

}

