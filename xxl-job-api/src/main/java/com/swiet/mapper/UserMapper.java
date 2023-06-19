package com.swiet.mapper;

import com.swiet.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author DengQiao
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-05-29 22:45:41
* @Entity com.swiet.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




