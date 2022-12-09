package xyz.fusheng.code.springboot.model.tools.orm.mysql;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ConnectionTest
 * @date 2022-12-09 23:06:27
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConnectionTest {

    private static final String url = "jdbc:mysql://42.192.222.62:33307/code-springboot-model?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true";
    private static final String user = "root";
    private static final String password = "123456";

    /**
     * 描述 Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void descriptionConnection() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://rm-bp15mj67u7y8p5761lo.mysql.rds.aliyuncs.com:3306/test-mybatis?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8", "root", "zH1314520");
        // 创建一个 Statement 对象，通过它能将 SQL 语句发送到数据库
        Statement statement = connection.createStatement();
        // 创建一个 CallableStatement 对象，通过它能够调用存储过程
        CallableStatement callableStatement = connection.prepareCall("");
        // 创建一个 PreparedStatement 对象，通过它能够将参数化的 SQL 语句发送到数据库
        PreparedStatement preparedStatement = connection.prepareStatement("", new String[]{});
        // 将输入的 SQL 转换成本地可用的 SQL 语句
        String nativeSQL = connection.nativeSQL("");
        // 提交当前事务
        connection.commit();
        // 回滚当前事务
        connection.rollback();
        // 关闭当前 Collection 对象
        connection.close();
        // 查询当前 Connection 是否有效
        boolean valid = connection.isValid(1000);
        // 设定 Connection 对象是否自动提交
        connection.setAutoCommit(true);
        // 获取/设置当前 Connection 对象的事务隔离级别
        connection.getTransactionIsolation();
        connection.setTransactionIsolation(Connection.TRANSACTION_NONE);
        // 获取当前 Connection 对象所连接数据库的元数据信息
        DatabaseMetaData metaData = connection.getMetaData();
    }

    /**
     * 存储过程
     * DELIMITER $$
     * CREATE PROCEDURE query_model (IN m_name varchar(50))
     * BEGIN
     *     SELECT * FROM code_model WHERE model_name = m_name;
     * END $$
     * DELIMITER ;
     * @throws Exception
     */
    @Test
    public void testCallProcedure() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        CallableStatement callableStatement = conn.prepareCall("{call query_model(?)}");
        callableStatement.setString(1, "test");
        // call query_model('test');
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("model_name");
            log.info("id:{} - modelName:{}", id, name);
        }
    }

}

