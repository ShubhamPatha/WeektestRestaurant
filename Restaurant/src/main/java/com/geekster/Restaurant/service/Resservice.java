package com.geekster.Restaurant.service;

import com.geekster.Restaurant.model.Res;
import com.geekster.Restaurant.repository.ResRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Resservice {
    @Autowired
    ResRepo resrepo;

    public  Res getUserdetail(Integer restaurantId) {

        List<Res> originalList = getAllRest();
        Res r1=new Res();
        for(Res res1:originalList)
        {
            if(res1.getRestaurantId()==restaurantId)
            {
                r1=res1;
                return r1;
            }
        }

        return  r1;
    }

    public List<Res> getAllRest() {
        return resrepo.getUsers();
    }



    public String addRes(List<Res> rest) {
        List<Res> originalList = getAllRest();
        originalList.addAll(rest);
        return "New users added";

    }


    public String updateuser(Integer userId, Res rest) {


        List<Res> originalList = getAllRest();

        for(Res user1: originalList)
        {
            if(user1.getRestaurantId()==userId)
            {
                user1=rest;
                return "updated";
            }
        }

        return "not found";
    }

    public String removeUser(Integer restaurantId) {


        List<Res> originalList = getAllRest();

        for(Res user1: originalList)
        {
            if(user1.getRestaurantId()==restaurantId)
            {
                originalList.remove(user1);
                return "user deleted";
            }
        }

        return  "user not found";
    }
}
