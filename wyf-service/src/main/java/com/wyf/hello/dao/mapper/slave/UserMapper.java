package com.wyf.hello.dao.mapper.slave;
import com.wyf.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @date 2019/02/19
 *
 * @author XX
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    void deleteById(int id);

    void delete(User user);

    void insert(User user);

    void update(User user);

    List<User> selectList(User user);
}
