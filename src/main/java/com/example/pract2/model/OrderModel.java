package com.example.pract2.model;

public class OrderModel {
    private int id;
    private String orderNumber;
    private double totalPrice;
    private String customerName;

    public OrderModel() {}  // Конструктор без аргументов

    public OrderModel(String orderNumber, double totalPrice, String customerName) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
    }

    // Геттеры и сеттеры для полей

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
