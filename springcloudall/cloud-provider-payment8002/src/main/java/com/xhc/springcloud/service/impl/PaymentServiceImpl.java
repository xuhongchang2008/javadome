package com.xhc.springcloud.service.impl;

import com.xhc.springcloud.dao.PaymentDao;
import com.xhc.springcloud.entities.Payment;
import com.xhc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther xhc
 * @create 2020-01-01 10:40
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
