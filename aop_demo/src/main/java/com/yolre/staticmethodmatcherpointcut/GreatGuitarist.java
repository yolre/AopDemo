package com.yolre.staticmethodmatcherpointcut;

import com.yolre.alliance.methodbeforeadvice.normal.Singer;

public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n" +
                "But I did not shoot the deputy");
    }
}
