package com.yolre.dyanmicmethodmatcherpointcut;

import com.yolre.staticmethodmatcherpointcut.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Static check for foo
 * Static check for bar
 * Static check for toString
 * Static check for clone 以上为初始阶段，所有方法被检查
 * Static check for foo   第一次被调用时
 * Dynamic check for foo
 * >> Invokingfoo
 * Invoked foo() with: 1
 * >> Done
 *
 * Dynamic check for foo
 * >> Invokingfoo
 * Invoked foo() with: 10
 * >> Done
 *
 * Dynamic check for foo
 * Invoked foo() with: 100
 * Static check for bar
 * Invoked bar()
 * Invoked bar()
 * Invoked bar()
 */
public class DynamicPointcutDemo {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(),new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        SampleBean proxy = (SampleBean) pf.getProxy();
        proxy.foo(1);
        proxy.foo(10);
        proxy.foo(100);

        proxy.bar();
        proxy.bar();
        proxy.bar();
    }
}
