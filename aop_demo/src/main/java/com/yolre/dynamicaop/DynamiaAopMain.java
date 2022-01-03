package com.yolre.dynamicaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//通知顺序：进入环绕通知、前置通知、proceed、退出环绕通知、后置通知、返回通知
public class DynamiaAopMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean bean = (TestBean) ac.getBean("test");
        bean.test();
    }
}
