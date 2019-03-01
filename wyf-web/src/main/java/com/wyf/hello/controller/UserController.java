package com.wyf.hello.controller;

import com.wyf.hello.UserService;
import com.wyf.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

/**
 * @author wenyf
 * @desc
 * @date 2019/2/21
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public void insert(@RequestBody User user){
        userService.insert(user);
    }

    @RequestMapping(value = "/selectList",method = RequestMethod.POST)
    public void selectList(@RequestBody User user){
        userService.selectList(user);
    }

    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public void selectById(@RequestParam Integer id){
        User user = userService.selectById(id);
        System.out.println(user);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }



}
