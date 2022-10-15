package com.learn.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.security.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by wangqinggang on 2021/3/5.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
