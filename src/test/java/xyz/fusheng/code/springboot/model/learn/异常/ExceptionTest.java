package xyz.fusheng.code.springboot.model.learn.异常;


import xyz.fusheng.code.springboot.core.exception.BusinessException;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ExceptionTest
 * @date 2022-12-06 14:12:24
 */

public class ExceptionTest {

    private static void testSuperException() {
        Child child = new Child();
        String s = child.returnName();
        System.out.println(s);
    }

    public static void main(String[] args) {
        testSuperException();
    }

}

class Parent {

    private String id;

    private String name;

    public String returnName() throws BusinessException {
        if (name != "code-fusheng") {
            throw new BusinessException("错误!");
        }
        return name;
    }

}

class Child extends Parent {

    private String age;

    @Override
    public String returnName() throws RuntimeException {
        if (age != "code-fusheng") {
            throw new RuntimeException();
        }
        return super.returnName();
    }
}
