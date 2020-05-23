package cn.tanyu.springcloud.controller;

import cn.tanyu.springcloud.cloudapicommons.entity.CommonResult;
import cn.tanyu.springcloud.cloudapicommons.entity.Payment;
import cn.tanyu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询成功" + serverPort, payment);
        }else {
            return new CommonResult(400, "对应Id没有记录" + serverPort, null);
        }
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult(200, "成功" + serverPort);
        }else {
            return new CommonResult(400, "创建订单失败" + serverPort);
        }
    }
}
