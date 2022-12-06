package xyz.fusheng.code.springboot.model.tools.orm.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @FileName: MysqlTest
 * @Author: code-fusheng
 * @Date: 2022/11/9 16:50
 * @Version: 1.0
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MysqlTest {

    private static final Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Test
    public void testMysql() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://rm-bp15mj67u7y8p5761lo.mysql.rds.aliyuncs.com:3306/test-mybatis?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8", "root", "zH1314520");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user where id = 1");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            logger.info("id:{} - name:{}", id, name);
        }
        stmt.close();
    }

}
