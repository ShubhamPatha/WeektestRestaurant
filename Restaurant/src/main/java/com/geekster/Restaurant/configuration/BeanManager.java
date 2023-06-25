package com.geekster.Restaurant.configuration;

import com.geekster.Restaurant.model.Res;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<Res> getInitializedList()
    {

       Res initUser = new Res("Headquarter","Delhi-Dwarka",1,"Kulfi",10);

        List<Res> initList = new ArrayList<>();
        initList.add(initUser);


        return initList;
    }

}
