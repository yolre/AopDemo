package com.yolre.staticmethodmatcherpointcut;

import com.yolre.alliance.methodbeforeadvice.normal.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * 希望通过使用相同的DefaultPointcutAdvisor创建这两个类的代理，但只将通知应用于
 * GoodGuitarist类的sing()方法
 */
public class StaticPonitcutDemo {
    public static void main(String[] args) {
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();

        Singer proxyOne;
        Singer proxyTwo;
        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);
        proxyOne = (Singer) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(ericClapton);
        proxyTwo = (Singer) pf.getProxy();

        proxyOne.sing();
        proxyTwo.sing();
    }
}
