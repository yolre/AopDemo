package com.yolre.delegatingintroductioninterceptor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * 封装mixin类的创建，这步是可选的，但它有助于确保为每个被通知对象使用一个新的mixin实例
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
