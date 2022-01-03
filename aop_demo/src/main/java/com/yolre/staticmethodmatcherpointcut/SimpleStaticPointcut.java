package com.yolre.staticmethodmatcherpointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> cls) {
        return ("sing".equals(method.getName()));
    }

    //返回一个ClassFilter实例，该实例的matches()方法仅针对GoodGuitarist类返回true
    @Override
    public ClassFilter getClassFilter() {
        return cls -> (cls == GoodGuitarist.class);
    }

    /*上面的代码示例中隐藏了在getClassFilter()中
    实现ClassFilter的匿名类的创建，扩展的lambda表达式如下：*/
//    @Override
//    public ClassFilter getClassFilter() {
//        return new ClassFilter() {
//            @Override
//            public boolean matches(Class<?> cls) {
//                return (cls == GoodGuitarist.class);
//            }
//        };
//    }
}
