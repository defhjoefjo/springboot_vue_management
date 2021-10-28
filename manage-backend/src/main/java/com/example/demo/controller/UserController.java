package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.common.ResultUtil;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.interfaces.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;
    @PostMapping
    public Result save(@RequestBody User user) {
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return ResultUtil.success(user);

    }
    @PutMapping
    public Result update(@RequestBody User user) {
        userMapper.updateById(user);
        return ResultUtil.success(user);
    }

    @DeleteMapping("/{id}")
    public Result update(@PathVariable Long id) {
        userMapper.deleteById(id);
        return ResultUtil.success(id);
    }
    @GetMapping
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StrUtil.isNotBlank(search)) {
            wrapper.like(User::getNickName,search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize), wrapper);
        return ResultUtil.success(userPage);
    }
}
