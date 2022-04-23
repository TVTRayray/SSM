package com.itheima.dao;

import com.itheima.domain.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> findAll();
}
