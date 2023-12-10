package cn.edu.buaa.controller;

import cn.edu.buaa.entity.User;
import cn.edu.buaa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author hwzhao
 * @Data 2023-12-09 17:31
 * @Version 1.0
 **/
@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login-success")
    public String loginSuccess(){
        return "登录成功";
    }


    @RequestMapping("/user/{id}")
    public User getuser(@PathVariable("id") String id){
        User User = userMapper.selectById(id);
        return User;
    }

    @RequestMapping("/r/r1")
    public String r1(){
        return "访问r1资源";
    }

    @RequestMapping("/r/r2")
    public String r2(){
        return "访问r2资源";
    }
}
