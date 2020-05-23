package cn.tanyu.springcloud.service;


import cn.tanyu.springcloud.cloudapicommons.entity.Payment;

public interface PaymentService {
    Payment getPaymentById(Long id);

    int create(Payment payment);
}
