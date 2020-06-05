package cn.tanyu.springcloud.controller;

import cn.tanyu.springcloud.cloudapicommons.entity.CommonResult;
import cn.tanyu.springcloud.cloudapicommons.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "111"));
        hashMap.put(2L, new Payment(2L, "222"));
        hashMap.put(3L, new Payment(3L, "333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult(200, "from mysql.server.port:" + serverPort, payment);
    }
}
