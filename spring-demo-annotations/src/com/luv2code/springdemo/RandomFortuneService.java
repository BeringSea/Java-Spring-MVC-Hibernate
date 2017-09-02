package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by David on 2017-08-06.
 */
@Component
public class RandomFortuneService implements FortuneService{
    private String[] array = new String[3];
    private Random myRandom = new Random();
    @Value("${test1}")
    private String test1;
    @Value("${test2}")
    private String test2;
    @Value("${test3}")
    private String test3;
    @Override
    public String getFortune() {
        array[0] = test1;
        array[1] = test2;
        array[2] = test3;

        int index = myRandom.nextInt(array.length);
        String result = array[index];
        return  result;
    }
}
