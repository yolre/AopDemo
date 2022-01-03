package com.yolre.alliance.throwadvice;

public class ErrorBean {
    public void errorProneMethod() throws Exception {
        throw new Exception("Gerneric Exception");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("IllegalArgumentException Exception");
    }
}
