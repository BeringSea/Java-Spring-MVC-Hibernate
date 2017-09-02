package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by David on 2017-08-07.
 */
@Configuration
public class MySportConfig {


    @Bean
    public FortuneService myFortuneInMyConfig(){
        return new MyFortuneService();
    }

    @Bean
    public Coach coachWithMyFortuneService(){
        return new CrossfitCoach(myFortuneInMyConfig());
    }

//    @Bean
//    public Coach coachFromConfig(){
//        return new CrossfitCoach();
//    }
}
