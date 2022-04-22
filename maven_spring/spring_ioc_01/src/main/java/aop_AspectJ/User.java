package aop_AspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


//被增强的类
@Component

public class User {
    public void add() {
        System.out.println("add.......");
    }
}
