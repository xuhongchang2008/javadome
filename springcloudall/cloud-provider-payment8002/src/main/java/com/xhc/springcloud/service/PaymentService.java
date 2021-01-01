package com.xhc.springcloud.service;

import com.xhc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther xhc
 * @create 2020-01-01 10:40
 */
public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
