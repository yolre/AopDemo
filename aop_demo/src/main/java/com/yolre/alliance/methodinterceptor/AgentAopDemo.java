package com.yolre.alliance.methodinterceptor;

import org.springframework.aop.framework.ProxyFactory;

/**
 * ProxyFactory：使用该类创建目标对象的代理，同时织入通知
 * 被通知类不依赖于Spring或AOP Alliance接口
 * AOP的优点在于，即使在不考虑AOP的情况下创建类，也可以为任何类提供通知，
 * SpringAOP中唯一的限制是不能通知最终的类，因为它们不能被覆盖且不能被代理
 */
public class AgentAopDemo {
    public static void main(String[] args) {
        Agent target = new Agent();

        ProxyFactory pf = new ProxyFactory();
        //通知传递
        pf.addAdvice(new AgentDecorator());
        //指定织入对象
        pf.setTarget(target);

        Agent proxy = (Agent) pf.getProxy();
        target.speak();
        System.out.println("-");
        proxy.speak();
    }
}
