package xyz.fusheng.code.springboot.model.learn.模式.builder;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc SunnySchool User 建造者类
 * @date 2022-12-08 00:13:18
 */

public class SunnySchoolUserBuilder implements UserBuilder {

    private String name;
    private String email;
    private Integer age;
    private Integer sex;
    private String schoolName;

    public SunnySchoolUserBuilder(String name) {
        this.name = name;
    }

    @Override
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public UserBuilder setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public User build() {
        if (this.name != null && this.email == null) {
            this.email = this.name.toLowerCase().replace(" ", "").concat("@sunnyschool.com");
        }
        if (this.age == null) {
            this.age = 7;
        }
        if (this.sex == null) {
            this.sex = 0;
        }
        this.schoolName = "Sunny School";
        return new User(name, email, age, sex, schoolName);
    }
}

