package cn.tanyu.springcloud.service.impl;

import cn.tanyu.springcloud.cloudapicommons.entity.Payment;
import cn.tanyu.springcloud.dao.PaymentDao;
import cn.tanyu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        int result = paymentDao.create(payment);
        return result;
    }
}
