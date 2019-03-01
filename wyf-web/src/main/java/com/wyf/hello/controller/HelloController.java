package com.wyf.hello.controller;

import com.wyf.hello.HelloService;
import com.wyf.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @PostMapping("selectAll")
    public List<User> selectAll() {
        List<User> userList = helloService.seelctAll();
        return  userList;
    }

}
