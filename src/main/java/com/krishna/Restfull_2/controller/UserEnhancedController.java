package com.krishna.Restfull_2.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.krishna.Restfull_2.models.User;
import com.krishna.Restfull_2.models.UserEnhanced;
import com.krishna.Restfull_2.service.UserEnhancedService;

import com.krishna.Restfull_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserEnhancedController {
    @Autowired
    UserEnhancedService userEnhancedService;
    @Autowired
    UserService userService;

//    //Ques 4
//    @GetMapping("/userEnhanced/filter")
//    public MappingJacksonValue filter(){
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userEnhancedService.getUsers());// here given user list
//        PropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password");
//        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserEnhancedFilter",filter);
//        mappingJacksonValue.setFilters(filterProvider);
//
//        return mappingJacksonValue;
//    }

    //ques 5
    // A) MimeType Versioning
    @GetMapping(path = "/user", produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<List<User>> getUsersYamlV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user", produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<List<UserEnhanced>> getUsersYamlV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }

    // B) Request Parameter versioning
    @GetMapping(path = "/user", params = "version=1")
    public ResponseEntity<List<User>> getUsersParamsV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user", params = "version=2")
    public ResponseEntity<List<UserEnhanced>> getUsersParamsV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }

    // C) URI versioning
    @GetMapping(path = "/v1/user")
    public ResponseEntity<List<User>> getUsersUrlV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/v2/user")
    public ResponseEntity<List<UserEnhanced>> getUsersUrlV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }


    // D) Custom Header Versioning
    @GetMapping(path = "/user", headers = "X-API-VERSION=1")
    public ResponseEntity<List<User>> getUsersHeaderV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user", headers = "X-API-VERSION=2")
    public ResponseEntity<List<UserEnhanced>> getUsersHeaderV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }

}
