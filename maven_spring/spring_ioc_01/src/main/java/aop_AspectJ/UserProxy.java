package aop_AspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component        //创建对象
@Aspect    //生成代理对象
@Order(1)    //多个动态代理 可以设置优先级 优先级越小 先调用
public class UserProxy {
    //切入点的抽取
    @Pointcut("execution( * aop_AspectJ.User.add())")
    public void point(){}

@Before("point()")
    public void before(){
        System.out.println("before==================");
    }
}
