package xyz.fusheng.code.springboot.model.tools.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc MybatisCountInterceptorTest
 * @date 2022-12-12 15:46:16
 */

@Slf4j
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class MybatisCountInterceptorTest implements Interceptor {

    private String info;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行原有方法
        Object result = invocation.proceed();
        // 打印原方法输出结果的数目
        log.info("输出结果数目:{}", ((List) result).size());
        return result;
    }

    @Override
    public void setProperties(Properties properties) {
        // 为拦截器设置属性
        info = properties.get("preInfo").toString();
    }
}

