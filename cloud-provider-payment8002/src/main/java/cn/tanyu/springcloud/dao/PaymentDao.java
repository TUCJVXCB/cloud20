package cn.tanyu.springcloud.dao;

import cn.tanyu.springcloud.cloudapicommons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {

    Payment getPaymentById(@Param("id") Long id);

    int create(Payment payment);
}
