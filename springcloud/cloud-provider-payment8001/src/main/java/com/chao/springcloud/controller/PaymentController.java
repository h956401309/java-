package com.chao.springcloud.controller;

import com.chao.springcloud.entities.CommonResult;
import com.chao.springcloud.entities.Payment;
import com.chao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@RestController("payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //服务发现功能  可以获取ip地址  端口号 主机名
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取所有服务名
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("==========="+element);
        }


        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances)
        {
            
            log.info("==========="+instance.getServiceId()+"========="+instance.getHost()+"=========="+instance.getPort()+"========"+instance.getUri());
        }
        return this.discoveryClient;
    }


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果"+result);

        if(result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }
        else{
            return new CommonResult(444,"插入数据失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        log.info("******插入结果"+payment);

        if(payment!=null){
            return new CommonResult(200,"查询数据成功,serverPort:"+serverPort,payment);
        }
        else{
            return new CommonResult(444,"查询数据失败"+id,null);
        }

    }




}



//@RestController
//@Slf4j
//public class PaymentController{
//    @Resource
//    private PaymentService paymentService;
//
//    @PostMapping(value = "/payment/create")
//    public CommonResult create(Payment payment)
//    {
//        int result = paymentService.create(payment);
//        log.info("*****插入结果："+result);
//
//        if(result > 0)
//        {
//            return new CommonResult(200,"插入数据库成功,serverPort: ",result);
//        }else{
//            return new CommonResult(444,"插入数据库失败",null);
//        }
//    }
//
//    @GetMapping(value = "/payment/get/{id}")
//    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
//    {
//        Payment payment = paymentService.getPayment(id);
//
//        if(payment != null)
//        {
//            return new CommonResult(200,"查询成功,serverPort:  ",payment);
//        }else{
//            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
//        }
//    }
//}