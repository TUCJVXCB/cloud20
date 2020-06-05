package cn.tanyu.springcloud.dao;

import cn.tanyu.springcloud.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    void create() {
        Order order = new Order();
        order.setUserId(1L);
        order.setProductId(1L);
        order.setCount(1);
        order.setMoney(new BigDecimal(10.5));
        orderDao.create(order);
    }

    @Test
    void update() {
        orderDao.update(1L, 0);
    }
}
