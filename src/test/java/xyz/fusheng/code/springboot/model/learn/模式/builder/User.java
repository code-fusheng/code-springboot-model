package xyz.fusheng.code.springboot.model.learn.模式.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 建造者模式测试对象 User
 * @date 2022-12-08 00:07:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String email;
    private Integer age;
    private Integer sex;
    private String schoolName;

}

