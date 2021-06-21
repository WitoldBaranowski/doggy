package com.doggy.DatabaseCon;

public class Response {
    private String customerUsername;
    private String statusMessage;

    public Response(String username) {
        this.customerUsername = username;
        this.statusMessage = "Customer Exists";
    }
    public Response(){
        this.statusMessage = "Customer does not exist";
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
