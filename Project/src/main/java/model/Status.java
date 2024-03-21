package model;

import java.util.Random;

public class Status {
    private String statusID;
    private String statusName;

    // Constructor
    public Status(String statusID, String statusName) {
        this.statusID = createStatusID();
        this.statusName = statusName;
    }

    // Getters and Setters
    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    // Tạo mã trạng thái đơn hàng
    public String createStatusID() {
        Random random = new Random();
        String id = "ST";
        for (int i = 0; i < 3; i++) {
            id += random.nextInt(10);
        }
        return id;
    }

}
