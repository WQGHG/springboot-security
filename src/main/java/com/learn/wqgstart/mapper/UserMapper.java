package com.learn.wqgstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.wqgstart.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by wangqinggang on 2022/10/5.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
