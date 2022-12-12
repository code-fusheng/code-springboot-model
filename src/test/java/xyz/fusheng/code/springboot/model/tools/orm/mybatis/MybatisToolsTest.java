package xyz.fusheng.code.springboot.model.tools.orm.mybatis;

import org.apache.ibatis.builder.ParameterExpression;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc MybatisToolsTest
 * @date 2022-12-06 15:16:32
 */

public class MybatisToolsTest {

    public static void testTypeParameterResolver() throws NoSuchMethodException {
        Type type1 = TypeParameterResolver.resolveReturnType(User.class.getMethod("getInfo"), User.class);
        System.out.println(type1);
        Type type2 = TypeParameterResolver.resolveReturnType(User.class.getMethod("getInfo"), Student.class);
        System.out.println(type2);
    }

    public static void testParameterExpression() {
        ParameterExpression expression = new ParameterExpression("count, mode=OUT, jdbcType=NUMERIC");
        System.out.println(expression);
    }

    public static void testSQLClass() {
        String sql = new SQL()
                .SELECT("*")
                .FROM("code_model")
                .WHERE("model_name #{modelName}")
                .toString();
        System.out.println(sql);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // testTypeParameterResolver();
        // testParameterExpression();
        testSQLClass();
    }

}

class User<T> {
    public List<T> getInfo() {
        return null;
    }
}

class Student extends User<Number> {
}

