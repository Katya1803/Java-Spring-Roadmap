package com.company.encapsulation.service;

import java.util.HashMap;
import java.util.Map;

import com.company.encapsulation.entity.User;
//Persistence service
public class UserPersistenceService {

    private static final Map<String, User> storage = new HashMap<>();

    public void saveUser(User user) {
       synchronized(storage) {
           storage.put(user.getName(), user);
       }     
    }

    public User getUserByName(String name) {
        synchronized(storage) {
            return storage.get(name);
        }    
    }
}