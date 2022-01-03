package com.yolre.alliance.afterreturningadvice.keycheck;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {

    public static void main(String[] args) {
        KeyGenerator generator = getKeyGenerator();
        for (int x = 0; x < 10; x++) {
            try {
                long key = generator.getKey();
                System.out.println("key: " + key);
            } catch (SecurityException e) {
                System.out.println("Weak Key Generated!");
            }
        }
    }

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(new WeakKeyCheckAdvice());
        return (KeyGenerator) pf.getProxy();
    }
}
