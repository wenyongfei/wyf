package com.wyf.hello.service.impl;

import com.wyf.hello.UserService;
import com.wyf.hello.dao.mapper.master.UserMapperWriter;
import com.wyf.hello.dao.mapper.slave.UserMapperReader;
import com.wyf.po.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author wenyf
 * @desc
 * @date 2019/2/21
 */
@Log
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapperReader userMapperReader;
    @Autowired
    private UserMapperWriter userMapperWriter;

    private Map<String, Object> param;

    public UserServiceImpl(Map<String, Object> param) {
        this.param = param;
    }


    @Override
    public User selectById(int id) {
        User user = userMapperReader.selectById(id);
        return user;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(User user) {

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(User user) throws ArithmeticException{
        try {
        userMapperWriter.insert(new User());
//        int num = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insert exception.....");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertList(List<User> users) {
        List<User> list = new ArrayList<>();
        for (int i = 0;i<100000;i++){
            User user1 = new User();
            user1.setPass("pass-"+i);
            user1.setName("name-"+i);
            list.add(user1);
        }
        try {
            userMapperWriter.insertList(list);
//        int num = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insertList exception.....");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(User user) throws Exception {
        try {
            userMapperWriter.update(user);
            int num = 1/0;
        } catch (Exception e) {
            log.info("" + e.toString() + e.getMessage());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            throw new Exception(e);
        }
    }

    @Override
    public List<User> selectList(User user) {
        List<User> users = userMapperReader.selectList(user);
        return users;
    }


}
