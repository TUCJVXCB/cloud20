package cn.tanyu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String payment_OK(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_OK,😭";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_TimeOut,😭";
    }
}
