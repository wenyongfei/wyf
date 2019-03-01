package com.wyf.hello.service.impl;

import com.wyf.hello.UserService;
import com.wyf.hello.dao.mapper.slave.UserMapper;
import com.wyf.po.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wenyf
 * @desc
 * @date 2019/2/21
 */
@Log
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectById(int id) {
        User user = userMapper.selectById(id);
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
        userMapper.insert(user);
        int num = 1/0;
//        try {
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("exception.....");
//        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(User user) throws Exception {
        try {
            userMapper.update(user);
            int num = 1/0;
        } catch (Exception e) {
            log.info("" + e.toString() + e.getMessage());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            throw new Exception(e);
        }
    }

    @Override
    public List<User> selectList(User user) {
        List<User> users = userMapper.selectList(user);
        return users;
    }
}
