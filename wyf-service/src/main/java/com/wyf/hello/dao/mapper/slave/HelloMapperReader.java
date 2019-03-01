package com.wyf.hello.dao.mapper.slave;

import com.wyf.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HelloMapperReader {

    @Select("select * from user")
    List<User> selectAll();
}
