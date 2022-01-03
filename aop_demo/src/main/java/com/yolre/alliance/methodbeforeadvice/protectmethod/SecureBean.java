package com.yolre.alliance.methodbeforeadvice.protectmethod;

/**
 * 这是要使用AOP进行安全保护的类
 */
public class SecureBean {
    public void writeSecureMessage(){
        System.out.println("Every time I learn something new," +
                "it pushes some old stuff out of my brain");
    }
}
