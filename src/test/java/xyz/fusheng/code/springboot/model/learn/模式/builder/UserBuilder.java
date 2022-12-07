package xyz.fusheng.code.springboot.model.learn.模式.builder;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc User 建造者接口
 * @date 2022-12-08 00:10:52
 */

public interface UserBuilder {

    public UserBuilder setEmail(String email);

    public UserBuilder setAge(Integer age);

    public UserBuilder setSex(Integer sex);

    public User build();

}