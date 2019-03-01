package com.wyf.hello.service.impl;

import com.wyf.hello.HelloService;
import com.wyf.hello.dao.mapper.slave.HelloMapperReader;
import com.wyf.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapperReader helloMapperReader;

    @Override
    public List<User> seelctAll() {
        List<User> userList = helloMapperReader.selectAll();
        return userList;
    }
}
