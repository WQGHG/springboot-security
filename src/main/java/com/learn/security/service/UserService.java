package com.learn.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.learn.security.mapper.UserMapper;
import com.learn.security.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by wangqinggang on 2021/3/5.
 */
@Component
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean register(User user) {

        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(User::getEmail, user.getEmail())
                .or().eq(User::getUserName, user.getUserName());
        User userExist = userMapper.selectOne(lambdaQueryWrapper);
        if (userExist != null){
            log.error("User is exist!");
            return false;
        }
        user.setUserPassWord(passwordEncoder.encode(user.getUserPassWord()));
        user.setCreateTime(LocalDate.now());
        try {
            userMapper.insert(user);
        }catch (Exception e) {
            log.error("User register failed: {}", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(User::getUserName, user.getUserName())
                .eq(User::getUserPassWord, passwordEncoder.encode(user.getUserPassWord()));
        User userExist = userMapper.selectOne(lambdaQueryWrapper);
        if (userExist == null) {
            return false;
        }
        return true;
    }

}
