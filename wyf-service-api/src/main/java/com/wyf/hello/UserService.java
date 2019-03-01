package com.wyf.hello;

import com.wyf.po.User;

import java.util.List;

/**
 * @desc:
 * @author: wenyf
 * @date:   2019/2/21
 */
public interface UserService {


    User selectById(int id);

    void deleteById(int id);

    void delete(User user);

    void insert(User user);

    void insertList(List<User> users);

    void update(User user) throws Exception;

    List<User> selectList(User user);

}
