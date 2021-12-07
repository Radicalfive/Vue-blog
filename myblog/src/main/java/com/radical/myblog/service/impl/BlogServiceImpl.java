package com.radical.myblog.service.impl;

import com.radical.myblog.entity.Blog;
import com.radical.myblog.mapper.BlogMapper;
import com.radical.myblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author radical
 * @since 2021-12-07
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
