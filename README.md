# Vue-blog
SpringBoot+Vue的前后端分离的博客项目

#### 文章总体分为2大部分，Java后端接口和vue前端页面
从零开始搭建一个项目骨架，最好选择合适，熟悉的技术，并且在未来易拓展，适合微服务化体系等。  
所以一般以Springboot作为我们的框架基础，这是离不开的了。
然后数据层，我们常用的是Mybatis，易上手，方便维护。但是单表操作比较困难，特别是添加字段或减少字段的时候，比较繁琐，  
所以这里我推荐使用Mybatis Plus（mp.baomidou.com/），为简化开发而生，只… CRUD 操作，从而节省大量时间。
作为一个项目骨架，权限也是我们不能忽略的，Shiro配置简单，使用也简单，所以使用Shiro作为我们的的权限。  

考虑到项目可能需要部署多台，这时候我们的会话等信息需要共享，Redis是现在主流的缓存中间件，也适合我们的项目。
然后因为前后端分离，所以我们使用jwt作为我们用户身份凭证。
ok，我们现在就开始搭建我们的项目脚手架！
#### 技术栈：

- SpringBoot
- mybatis plus
- shiro
- lombok
- redis
- hibernate validatior
- jwt
