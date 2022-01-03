package com.yolre.delegatingintroductioninterceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 本例invoke()方法可以在修改发生时进行自动检测，只有当对象仍未修改时，才开始执行修改检测；
 * 一旦知道对象已被修改，就不需要进行修改检测。
 * 查看该方法是否是setter方法，是则检索相应的getter方法，并对getter/setter方法进行缓存
 * 当使用DelegatingIntroductionInterceptor时，必须在重写invoke()时调用super.invoke()，
 * 因为是由DelegatingIntroductionInterceptor将调用分派到正确的位置(被通知对象或mixin本身)
 */
public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {
    private boolean isModified = false;
    private Map<Method, Method> methodCache = new HashMap<>();

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (!isModified) {
            if ((invocation.getMethod().getName().startsWith("set"))
                    && (invocation.getArguments().length == 1)) {
                Method getter = getGetter(invocation.getMethod());

                if (getter != null) {
                    Object newVal = invocation.getArguments()[0];
                    Object oldVal = getter.invoke(invocation.getThis(), null);
                    if ((newVal == null) && (oldVal == null)) {
                        isModified = false;
                    } else if ((newVal == null) && (oldVal != null)) {
                        isModified = true;
                    } else if ((newVal != null) && (oldVal == null)) {
                        isModified = true;
                    } else {
                        isModified = !newVal.equals(oldVal);
                    }
                }
            }
        }
        return super.invoke(invocation);
    }

    private Method getGetter(Method setter) {
        Method getter = methodCache.get(setter);
        if (getter != null) {
            return getter;
        }

        String getterName = setter.getName().replaceFirst("set", "get");
        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);
            synchronized (methodCache) {
                methodCache.put(setter, getter);
            }
            return getter;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
