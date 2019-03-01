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
public interface UserMapperReader {

    User selectById(int id);



    List<User> selectList(User user);
}
