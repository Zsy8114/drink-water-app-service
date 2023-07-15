package com.example.demo.dto;



import com.example.demo.mapper.domain.user;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserDto  {
    private Long id;
    /**
     * active 逻辑删除(0-未删除 1-已删除）
     */
    private String active;
    /**
     * 用户名字
     */
    private String name;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户年龄
     */
    private String age;
    /**
     * 出生日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthTime;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 账户状态0-正常 1-禁用
     */
    private String status;
    /**
     * 账号
     */
    private String identity;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 分页
     */
    private String pageNum;
    /**
     * 分页
     */
    private String pageSize;

}
