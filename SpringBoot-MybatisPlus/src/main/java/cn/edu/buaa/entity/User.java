package cn.edu.buaa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description 用户表
 * @Author hwzhao
 * @Data 2023/12/8 16:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
}
