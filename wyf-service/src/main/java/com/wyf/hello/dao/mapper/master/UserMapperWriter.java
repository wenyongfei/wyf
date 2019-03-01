package com.wyf.hello.dao.mapper.master;

import com.wyf.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wenyf
 * @desc
 * @date 2019/03/01
 */
@Mapper
public interface UserMapperWriter {

    void deleteById(int id);

    void delete(User user);

    void insert(User user);

    void update(User user);

    void insertList(List<User> list);
}
