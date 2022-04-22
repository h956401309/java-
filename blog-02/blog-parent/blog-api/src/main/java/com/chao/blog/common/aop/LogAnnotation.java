package com.chao.blog.common.aop;

import java.lang.annotation.*;

//TYPE可以放在类上  METHOD可以放在方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String module() default "";

    String operator() default "";
}
