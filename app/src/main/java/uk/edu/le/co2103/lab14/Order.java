package uk.edu.le.co2103.lab14;

public class Order {
    private String productName;
    private String customerName;
    private String customerPhone;
    private String orderDate;

    public Order(){} //default constructor
    public Order(String productName, String customerName, String orderDate){ //min requirements for order
        this.productName = productName;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public Order(String productName, String customerName, String customerPhone, String orderDate) {
        this.productName = productName;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
