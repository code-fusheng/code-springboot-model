package xyz.fusheng.code.springboot.model.learn.高级;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc IsAssignableFromTest
 * @date 2022-12-06 11:33:43
 */

public class IsAssignableFromTest {

    public static void main(String[] args) {

        // 检测入参类型是否是指定类型
        String str = "test";
        Class<? extends String> aClass = str.getClass();
        System.out.println(String.class.isAssignableFrom(aClass));

    }

}

