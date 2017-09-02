package com.luv2code.springdemo;

import java.util.Random;

/**
 * Created by David on 2017-08-02.
 */
public class HappyFortuneService implements FortuneService {
    private String[] array = new String[3];
    @Override
    public String getFortune() {
        array[0] = "Test 1";
        array[1] = "Test 2";
        array[2] = "Test 3";

        String result = "";

        int id = new Random().nextInt(array.length);
        result = array[id];

        return result;
    }
}
