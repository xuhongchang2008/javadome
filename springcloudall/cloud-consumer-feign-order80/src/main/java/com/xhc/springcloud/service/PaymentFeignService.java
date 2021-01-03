package com.xhc.springcloud.service;

import com.xhc.springcloud.entities.CommonResult;
import com.xhc.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther xhc
 * @create 2020-02-19 23:59
 */
@Component //注册到容器中
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //服务名称
public interface PaymentFeignService
{
    @GetMapping(value = "/payment/get/{id}") //接口名称
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout") //接口名称
    public String paymentFeignTimeout();
}
