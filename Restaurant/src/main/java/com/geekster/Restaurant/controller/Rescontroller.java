package com.geekster.Restaurant.controller;

import com.geekster.Restaurant.model.Res;
import com.geekster.Restaurant.service.Resservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rescontroller {
@Autowired
    Resservice resservice;

@GetMapping("Restaurant/List")
    List<Res> getAllRestaurant(){  return  resservice.getAllRest();}

    @PostMapping("Restaurant/List/add")
    String addUsers(@Valid @RequestBody List<Res> Rest)
    {
        return resservice.addRes(Rest);
    }

    @GetMapping("Restaurant/{restaurantId}")
    Res getResdetail(@PathVariable Integer restaurantId)
    {
        return resservice.getUserdetail(restaurantId);
    }

    @PutMapping("Restaurant/{restaurantId}")
    String ResSpeciality(@PathVariable Integer restaurantId, Res Rest)
    {
        return resservice.updateuser(restaurantId,Rest);
    }

    @DeleteMapping("Restaurant/{restaurantId}")
    String removeUser(@PathVariable Integer restaurantId)
    {
        return resservice.removeUser(restaurantId);
    }




}
