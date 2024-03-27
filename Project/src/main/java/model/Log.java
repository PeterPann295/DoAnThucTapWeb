package model;

import java.sql.Date;

public class Log {
    private int id;
    private String level;
    private Customer customerID;
    private String ip;
    private String national;
    private String action;
    private String details;
    private Date date;

    public Log(int id, String level, Customer customerID, String ip, String national, String action, String details, Date date) {
        this.id = id;
        this.level = level;
        this.customerID = customerID;
        this.ip = ip;
        this.national = national;
        this.action = action;
        this.details = details;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
