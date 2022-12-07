package xyz.fusheng.code.springboot.model.learn.模式.builder;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Builder 建造者模式
 * @date 2022-12-08 00:04:50
 *
 * 使用建造者模式，对象的建造细节均交给建造者来完成，调用者只需掌控总体流程即可，而不需要了解被建造对象的细节。
 * 例如，某个平台需要在开学季给Sunny School和Garden School两所学校的新同学注册账号。
 * Sunny School是一所小学，新同学年龄大多为 7岁；
 * Garden School是一所中学，新同学年龄大多为 13岁。
 * 在注册账号的过程中，如果同学没有电子邮箱的话还要为其注册电子邮箱。
 *
 * 基于建造者创建对象时，有以下几个优点:
 * · 使用建造者时十分灵活，可以一次也可以分多次设置被建造对象的属性；
 * · 调用者只需调用建造者的主要流程而不需要关系建造对象的细节；
 * · 可以很方便地修改建造者的行为，从而建造出不同的对象。
 *
 * 建造者一般包含两类方法:
 * · 一类是属性设置方法。这类方法一般有多个，可以接受不同类型的参数来设置建造者的属性。
 * · 一类是目标对象生成方法。该类方法一般只有一个，即根据目前建造者中的属性创建出一个目标对象。
 *
 */

public class BuilderTest {

    public static void main(String[] args) {

        User user = new SunnySchoolUserBuilder("code-fusheng").setSex(24).setSex(1).build();
        System.out.println(user);

    }

}

