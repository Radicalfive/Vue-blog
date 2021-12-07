package com.radical.myblog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.radical.myblog.common.LoginDto;
import com.radical.myblog.common.ResponseResult;
import com.radical.myblog.entity.User;
import com.radical.myblog.service.UserService;
import com.radical.myblog.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : radical
 * @description :账号控制器
 * @data : 2021/12/7
 **/
@RestController
public class AccountController {
    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserService userService;

    /**
     * 登录，数据库中默认账号密码：radical/123456
     *
     * @param loginDto loginDto
     * @param response response
     * @return ResponseResult 响应结果
     */
    @CrossOrigin
    @PostMapping("/login")
    public ResponseResult login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user, "用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return ResponseResult.fail("密码错误！");
        }
        String jwt = jwtUtil.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        return ResponseResult.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    /**
     * 退出登录
     *
     * @return ResponseResult
     */
    @GetMapping("/logout")
    @RequiresAuthentication
    public ResponseResult logout() {
        SecurityUtils.getSubject().logout();
        return ResponseResult.success(null);
    }
}
