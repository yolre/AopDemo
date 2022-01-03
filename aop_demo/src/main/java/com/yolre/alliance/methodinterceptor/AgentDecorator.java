package com.yolre.alliance.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * MethodInterceptor：该接口是一个标准的 AOP Alliance接口，用于实现方法调用的连接点的环绕通知
 */
public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("James");
        Object reVal = invocation.proceed();
        System.out.println("!");
        return reVal;
    }
}
