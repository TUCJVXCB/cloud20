package cn.tanyu.springcloud.cloudconsumerfeignorder80.controller;

import cn.tanyu.springcloud.cloudapicommons.entity.CommonResult;
import cn.tanyu.springcloud.cloudapicommons.entity.Payment;
import cn.tanyu.springcloud.cloudconsumerfeignorder80.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/timeout")
    public String timeout() {
        return paymentFeignService.timeout();
    }
}
