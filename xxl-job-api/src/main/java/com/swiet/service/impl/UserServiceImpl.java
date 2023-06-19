package com.swiet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swiet.domain.User;
import com.swiet.service.UserService;
import com.swiet.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author DengQiao
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-05-29 22:45:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




