package com.yolre.alliance.throwadvice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Spring在异常通知中寻找的第一方法是一个或多个被称为afterThrowing()的公共方法
 * 当抛出常见的旧的Exception时会调用第一个afterThrowing()方法
 * 但抛出IllegalArgumentException时，则会调用第二个afterThrowing()方法
 * Spring将使用其签名包含Exception类型的最佳匹配方法
 *  当后置通知有两个且相同Exception类型声明的afterThrowing(),优先调用参数最多的那个
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(errorBean);
        proxyFactory.addAdvice(new SimpleThrowsAdvice());

        ErrorBean proxy = (ErrorBean) proxyFactory.getProxy();
        try {
            proxy.errorProneMethod();
        } catch (Exception ignored) {
        }
        try {
            proxy.otherErrorProneMethod();
        } catch (Exception ignored) {
        }
    }

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object args, Object target, IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}
