package com.company.encapsulation.controller;

import java.io.IOException;

import com.company.encapsulation.entity.User;
import com.company.encapsulation.service.UserPermissionService;
import com.company.encapsulation.service.UserPersistenceService;
import com.company.encapsulation.service.UserStorageService;
import com.fasterxml.jackson.databind.ObjectMapper;

//Handles user request
public class UserController {

    private UserPersistenceService persistenceService = new UserPersistenceService();

    private UserStorageService storageService = new UserStorageService();

    private UserPermissionService permissionService = new UserPermissionService();

    //creates user
    public String createUser(String request) {
        ObjectMapper mapper = new ObjectMapper();

        User usr;
        try {
            usr = mapper.readValue(request, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
        
        persistenceService.saveUser(usr);            
        if(usr.getTier() == null || usr.getTier().trim().length() == 0) {
            usr.setTier("BASIC");
        }
        if(usr.getTier().equalsIgnoreCase("basic")) {
                storageService.allocateStorage(usr, 100);
                permissionService.grantPermission(usr, "RECEIVE_EMAIL");
        } else if(usr.getTier().equalsIgnoreCase("premium")) {
                storageService.allocateStorage(usr, 200);
                permissionService.grantPermission(usr, "RECEIVE_EMAIL");
                permissionService.grantPermission(usr, "SEND_EMAIL");
        } else {
        	return "ERROR";
        }
        return "SUCCESS";
    }

}