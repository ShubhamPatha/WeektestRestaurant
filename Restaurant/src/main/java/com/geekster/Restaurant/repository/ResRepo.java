package com.geekster.Restaurant.repository;

import com.geekster.Restaurant.model.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResRepo {

    @Autowired
    private List<Res> userList;

    public List<Res> getUsers() {
        return userList;}



}
