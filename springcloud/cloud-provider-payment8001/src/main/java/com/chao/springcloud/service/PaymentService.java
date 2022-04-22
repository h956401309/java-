package com.chao.springcloud.service;

import com.chao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPayment(@Param("id")Long id);
}
