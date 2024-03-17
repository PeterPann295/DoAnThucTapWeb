package model;

public class Status {
    private int statusID;
    private String statusName;

    // Constructor
    public Status(int statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    // Getters and Setters
    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
