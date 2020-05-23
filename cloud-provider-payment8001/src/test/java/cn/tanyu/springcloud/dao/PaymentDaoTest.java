package cn.tanyu.springcloud.dao;

import cn.tanyu.springcloud.cloudapicommons.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentDaoTest {

    @Autowired
    private PaymentDao paymentDao;

    @Test
    void getPaymentById() {
        Payment payment = paymentDao.getPaymentById(1L);
        System.out.println(payment);
    }

    @Test
    void create() {
        Payment payment = new Payment();
        payment.setSerial("fuckyou");
        int i = paymentDao.create(payment);
        System.out.println(i);
    }
}
