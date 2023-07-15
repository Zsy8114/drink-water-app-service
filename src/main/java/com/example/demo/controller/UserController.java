package com.example.demo.controller;


import com.example.demo.common.MsgInfo;
import com.example.demo.controller.vo.addUserForm;
import com.example.demo.controller.vo.loginUserForm;
import com.example.demo.controller.vo.updateUserForm;
import com.example.demo.dto.UserDto;
import com.example.demo.service.impl.UserServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    ObjectMapper objectMapper;
    @Autowired
    UserServiceimpl userServiceimpl;

    @PostMapping("/add-User")
    public MsgInfo<String> addUser(@RequestBody addUserForm addUserInfo) {
        userServiceimpl.addUser(objectMapper.convertValue(addUserInfo, UserDto.class));
        return MsgInfo.success("用户添加成功");
    }

    @PostMapping("/login")
    public MsgInfo<String> login(HttpServletRequest request, @RequestBody loginUserForm loginUserInfo) {
   if(userServiceimpl.login(objectMapper.convertValue(loginUserInfo,UserDto.class))==false){
       return MsgInfo.error("登录失败");
   }
   else{
       return MsgInfo.success("登录成功");
   }
    }

    @PostMapping("/delete/{id:.+}")
    public MsgInfo<String> delete(@PathVariable Long id) {
        userServiceimpl.deleteUser(id);
        return MsgInfo.success("删除成功");
    }

    @PostMapping("update")
    public MsgInfo<String> update(@RequestBody updateUserForm updateUserInfo) {
        userServiceimpl.updateUser(objectMapper.convertValue(updateUserInfo,UserDto.class));
        return MsgInfo.success("修改成功");
    }
}
