package com.example.demo.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Contants;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.domain.user;
import com.example.demo.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceimpl extends ServiceImpl<UserMapper, user> implements IUserService {
    @Resource
    ObjectMapper objectMapper;

    //增加用户
    @Override
    public void addUser(UserDto userDto) {
        userDto.setActive(Contants.ActiveEnum.NOT_DELETE.getValue());
        baseMapper.insert(objectMapper.convertValue(userDto, user.class));
    }

    @Override
    public boolean login(UserDto user) {
    String identity=user.getIdentity();
    String password=user.getPassword();
    UserDto userDto=objectMapper.convertValue(baseMapper.findByIdentity(identity),UserDto.class);
    if(StringUtils.equals(password,userDto.getPassword())){
        return true;
    }else{
        return false;
    }
    }

    //注销用户
    @Override
    public void deleteUser(Long id) {
        UserDto userDto = objectMapper.convertValue(baseMapper.findById(id), UserDto.class);
        userDto.setActive(Contants.ActiveEnum.DELETE.getValue());
        LambdaQueryWrapper<user> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(com.example.demo.mapper.domain.user::getId, id);
        baseMapper.update(objectMapper.convertValue(userDto,user.class), queryWrapper);
    }

    @Override
    public void updateUser(UserDto updateUser) {
        //修改
        LambdaQueryWrapper<user>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(user::getIdentity,updateUser.getIdentity());
        baseMapper.update(objectMapper.convertValue(updateUser,user.class),queryWrapper);
    }



}



