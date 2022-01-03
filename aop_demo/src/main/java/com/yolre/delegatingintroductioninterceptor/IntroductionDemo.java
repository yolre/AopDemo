package com.yolre.delegatingintroductioninterceptor;

import org.springframework.aop.framework.ProxyFactory;

public class IntroductionDemo {
    public static void main(String[] args) {
        Contact target = new Contact();
        target.setName("John Mayer");
        IsModifiedAdvisor advisor = new IsModifiedAdvisor();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        //强制使用CGLIB
        pf.setOptimize(true);
        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        System.out.println("Has been modified?: " + (proxyInterface.isModified()));

        proxy.setName("John Mayer");
        System.out.println("Has been modified?: " + (proxyInterface.isModified()));

        proxy.setName("Eric Clapton");
        System.out.println("Has been modified?: " + (proxyInterface.isModified()));

    }
}
