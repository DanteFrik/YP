package com.example.pract2.dao;

import com.example.pract2.model.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAO implements GenericDAO<OrderModel> {
    private final List<OrderModel> orders = new ArrayList<>();
    private int idCounter = 1;

    public OrderDAO() {
        create(new OrderModel("Order001", 100.0, "Customer1"));
        create(new OrderModel("Order002", 150.0, "Customer2"));
        create(new OrderModel("Order003", 200.0, "Customer3"));
    }

    @Override
    public List<OrderModel> getAll() {
        return orders;
    }

    @Override
    public OrderModel getById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void create(OrderModel order) {
        order.setId(idCounter++);
        orders.add(order);
    }

    @Override
    public void update(int id, OrderModel updatedOrder) {
        OrderModel existingOrder = getById(id);
        if (existingOrder != null) {
            existingOrder.setOrderNumber(updatedOrder.getOrderNumber());
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
            existingOrder.setCustomerName(updatedOrder.getCustomerName());
        }
    }

    @Override
    public void delete(int id) {
        orders.removeIf(order -> order.getId() == id);
    }
}
