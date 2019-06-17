package com.smvc.annotation.components.root.service.impl;

import com.smvc.annotation.components.root.bean.User;
import com.smvc.annotation.components.root.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author tk
 * @date 2019/6/12 0:27
 * @desc
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user = new User();
        user.setAge(20);
        user.setName("张三");
        return user;
    }
}
