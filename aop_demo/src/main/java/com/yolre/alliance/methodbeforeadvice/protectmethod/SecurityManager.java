package com.yolre.alliance.methodbeforeadvice.protectmethod;

/**
 * 负责验证用户并存储其凭据
 */
public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String userName, String password) {
        threadLocal.set(new UserInfo(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }

}