package com.yolre.dyanmicmethodmatcherpointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * 无须在方法匹配方法中对类进行检查，这对于动态检查特别重要。但该例仍然实现了静态检查，原因是bar()方法永远不会被通知
 * 通过使用静态检查来指明这一点，Spring就不必为此方法执行动态检查，这是因为当执行静态检查方法时，Spring
 * 首先检查bar()方法，如果检查结果不匹配，Spring将停止进一步的动态检查。此外，静态检查的结果将被缓存以获得更好的性能
 * 若省略静态检查，Spring则会在每次调用bar()方法时执行动态检查
 * 推荐做法：
 *  在getClassFilter()方法中执行类检查，在matches(Method,Class<?>)方法中执行方法检查以及在matches(Method,Class<?>,Object[])方法中执行参数检查
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> cls) {
        System.out.println("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public boolean matches(Method method, Class<?> cls, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        int x = ((Integer) args[0]).intValue();
        return (x != 100);
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls -> (cls == SampleBean.class);
    }
}
