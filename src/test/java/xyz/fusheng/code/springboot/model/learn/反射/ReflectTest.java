package xyz.fusheng.code.springboot.model.learn.反射;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;
import xyz.fusheng.code.springboot.model.model.entity.SysUser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ReflectTest
 * @date 2022-12-06 11:37:14
 */

public class ReflectTest {

    private static void testNoConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SysUser user = new SysUser();
        Class<? extends SysUser> userClass = user.getClass();
        Constructor<? extends SysUser> constructor = userClass.getDeclaredConstructor();
        SysUser sysUser = null;
        try {
            sysUser = constructor.newInstance();
        } catch (IllegalAccessException e) {
            constructor.setAccessible(true);
            sysUser = constructor.newInstance();
        }
        System.out.println(sysUser);
    }

    private static void testAllConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SysUser user = new SysUser();
        Class<? extends SysUser> userClass = user.getClass();
        List<Class<?>> constructorArgTypes = new ArrayList<Class<?>>();
        constructorArgTypes.add(String.class);
        Constructor<? extends SysUser> declaredConstructor = userClass.getDeclaredConstructor(constructorArgTypes.toArray(new Class[0]));
        SysUser user1 = declaredConstructor.newInstance("1");
        System.out.println(user1);
    }

    /**
     * 反射
     * @throws IllegalAccessException
     */
    private static void testSuperClass() throws IllegalAccessException {
        Child child = new Child();
        child.setName("test");
        child.setId("1");
        Class<?> aClass = child.getClass();
        while (aClass != null) {
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object o = declaredField.get(child);
                System.out.println(o);
            }
            aClass = aClass.getSuperclass();
        }
    }

    private static void testParameterAnnotations() throws NoSuchMethodException {
        Child child = new Child();
        Method[] methods = child.getClass().getMethods();
        for (Method method : methods) {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            System.out.println(Arrays.deepToString(parameterAnnotations));
        }
    }

    public static void main(String[] args) throws Exception {
        // testAllConstructor();
        // testSuperClass();
        testParameterAnnotations();
    }


}

@Data
class Parent {
    private String id;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Child extends Parent {
    private String name;

    public Boolean test(@Param("name") String name) {
        return this.name.equals(name);
    }
}

