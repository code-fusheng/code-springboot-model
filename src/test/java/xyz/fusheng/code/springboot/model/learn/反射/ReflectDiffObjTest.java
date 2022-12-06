package xyz.fusheng.code.springboot.model.learn.反射;

import xyz.fusheng.code.springboot.model.model.entity.SysUser;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ReflectDiffObjTest
 * @date 2022-12-06 10:52:12
 */

public class ReflectDiffObjTest {

    /**
     * 比较对象属性
     * @param oldObj
     * @param newObj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, String> diffObj(Object oldObj, Object newObj) throws IllegalAccessException {
        HashMap<String, String> diffMap = new HashMap<>();
        Class<?> oldObjClass = oldObj.getClass();
        Class<?> newObjClass = newObj.getClass();
        if (Objects.equals(oldObjClass, newObjClass)) {
            Field[] fields = oldObjClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object oldValue = field.get(oldObj);
                Object newValue = field.get(newObj);
                if ((oldValue == null && newValue != null) || oldValue != null && !oldValue.equals(newValue)) {
                    diffMap.put(field.getName(), " from " + oldValue + " to " + newValue);
                }
            }
        }
        return diffMap;
    }

    public static void main(String[] args) throws IllegalAccessException {
        SysUser user1 = new SysUser();
        user1.setUsername("xxxx");
        SysUser user2 = new SysUser();
        user2.setUsername("yyyy");
        System.out.println(diffObj(user1, user2));
    }

}

