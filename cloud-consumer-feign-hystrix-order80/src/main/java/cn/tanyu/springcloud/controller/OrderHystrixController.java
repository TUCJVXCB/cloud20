package cn.tanyu.springcloud.controller;

import cn.tanyu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.payment_OK(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己";
    }

    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息， 请稍后再试";
    }
}
