package com.wyf;

import com.wyf.hello.UserService;
import com.wyf.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wenyf
 * @desc
 * @date 2019/02/21
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectById(){
        User user = userService.selectById(1);
        System.out.println(user);
    }

    @Test
    public void selectList(){
        User user1 = new User();
        List<User> users = userService.selectList(user1);
        System.out.println(users);
    }

    @Test
    public void insert(){
        User user1 = new User();
        user1.setName("王五");
        user1.setPass("");
        try {
            userService.insert(user1);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("#################");
        }
    }

    @Test
    public void update(){
        User user1 = new User();
        user1.setId(2);
        user1.setName("王老五");
        user1.setPass("678");
        try {
            userService.update(user1);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("#################");
        }
    }


}
