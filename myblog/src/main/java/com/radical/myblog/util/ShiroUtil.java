package com.radical.myblog.util;

import com.radical.myblog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author : radical
 * @description :ShiroUtil工具类
 * @data : 2021/12/7
 **/
public class ShiroUtil {
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}