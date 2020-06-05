package cn.tanyu.springcloud.service.impl;

import cn.tanyu.springcloud.dao.OrderDao;
import cn.tanyu.springcloud.entity.Order;
import cn.tanyu.springcloud.service.AccountService;
import cn.tanyu.springcloud.service.OrderService;
import cn.tanyu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("-------->开始新建订单");
        orderDao.create(order);

        log.info("-------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------->订单微服务开始调用库存，做扣减End");

        log.info("-------->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------->订单微服务开始调用账户，做扣减End");

        log.info("-------->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-------->修改订单状态结束");

        log.info("-------->下订单结束了");
    }
}
