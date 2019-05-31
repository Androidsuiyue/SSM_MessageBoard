package com.qzhenghao.aop;

import com.qzhenghao.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


/**
 * Created by 符柱成 on 2017/8/3.
 */
@Component
@Aspect
public class AESAspect {

    @Before(value = "execution(public * com.qzhenghao.controller.*.*(..))" )
    public void beforeShow(JoinPoint jp) {
        String className = jp.getThis().toString();
        String methodName = jp.getSignature().getName();
        System.out.println("执行方法：类"+className+"，方法："+methodName);
    }

    @AfterReturning(value="execution(* com.qzhenghao.serviceImpl.UserServiceImpl.login(..))",returning = "returnVal")
    public User AfterReturning(JoinPoint joinPoint,Object returnVal){
        User user = (User) returnVal;

        return user;
    }
}
