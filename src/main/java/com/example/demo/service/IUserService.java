package com.example.demo.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.domain.user;

public interface IUserService extends IService<user> {
    /**
     * 注册
     *
     * @param userDto
     */
    void addUser(UserDto userDto);
    /**
     * 登录
     */
    boolean login(UserDto userDto);
    /**
     * 注销（逻辑删除）
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 用户跟新
     * @param userDto
     */
    void updateUser(UserDto userDto);



}
