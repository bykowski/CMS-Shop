package com.adrian.cmsshoppingcart.security.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class RegisterAspect {

    @Before("@annotation(RegisterInfo)")
    public void beforeRegister() {
        System.out.println("new registration");
    }

    @After("@annotation(RegisterInfo)")
    public void afterRegister() {
        Date data = new Date();
        System.out.println("new registration date: " + data);
    }


}
