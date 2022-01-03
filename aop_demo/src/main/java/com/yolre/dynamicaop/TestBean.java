package com.yolre.dynamicaop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestBean {
    private String testStr = "testStr";

    public void test() {
        System.out.println("test");
    }
}
