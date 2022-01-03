package com.yolre.jdkregexpmethodpointcut;

import com.yolre.alliance.methodbeforeadvice.normal.Singer;

public class Guitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2() {
        System.out.println("Just keep me where the light is");
    }

    public void rest() {
        System.out.println("zzz");
    }
}
