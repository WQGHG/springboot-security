package com.learn.wqgstart.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by wangqinggang on 2022/10/5.
 */
@Data
public class User {

    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;

    @TableField(value = "email")
    private String email;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_role")
    private String userRole;

    @TableField(value = "user_password")
    private String userPassWord;

    @TableField(value = "create_time")
    private LocalDate createTime;

    @TableField(value = "last_time")
    private LocalDateTime lastTime;

}
