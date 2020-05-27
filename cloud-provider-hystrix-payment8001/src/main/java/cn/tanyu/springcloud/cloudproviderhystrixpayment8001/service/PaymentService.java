package cn.tanyu.springcloud.cloudproviderhystrixpayment8001.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "payment_OK,id:" + id + "\t" + "😂";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("我被调用了");
        return " 线程池： " + Thread.currentThread (). getName()+ "   paymentInfo_TimeOut,id ：   " + id + " \t " + " 呜呜呜 " + "  耗 时 ( 秒 )" + timeNumber;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "调用支付接口超时或者异常:" + "\t" + "\t当前线程池名字" + Thread.currentThread().getName();
    }
}
