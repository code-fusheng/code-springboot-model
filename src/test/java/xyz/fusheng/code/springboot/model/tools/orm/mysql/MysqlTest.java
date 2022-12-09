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

    private static final String url = "jdbc:mysql://42.192.222.62:33307/code-springboot-model?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true";
    private static final String user = "root";
    private static final String password = "123456";

    @Test
    public void testMysql() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from code_model where id = 1598134730123902977");
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("model_name");
            logger.info("id:{} - modelName:{}", id, name);
        }
        stmt.close();
    }

}
