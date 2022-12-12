package xyz.fusheng.code.springboot.model.tools.orm.mysql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testSqlRunnerClass() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM code_model WHERE model_name =?";
        SqlRunner sqlRunner = new SqlRunner(conn);
        List<Map<String, Object>> result = sqlRunner.selectAll(sql, "test");
        logger.info("result:{}", result);

        // 使用 SqlRunner 时，如果参数为 null，需要通过引用枚举类型 Null，这其中包含了类型信息与类型处理器信息
        // int update = sqlRunner.update("", Null.STRING);
    }

    @Test
    public void testScriptRunner() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.runScript(Resources.getResourceAsReader("update_model.sql"));
    }

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
        /** 创建一个 CallableStatement 对象，通过它能够调用存储过程 {@link ConnectionTest#testCallProcedure() } **/
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
            logger.info("id:{} - modelName:{}", id, name);
        }
    }

    /**
     * 描述 Statement 对象
     */
    public void descriptionStatement() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        // 将给定的 SQL 命令批量添加至 Statement 对象的 SQL 命令列表中。
        stmt.addBatch("");
        // 清除
        stmt.clearBatch();
        // 执行一条 SQL
        boolean execute = stmt.execute("");
        // 批量执行多个命令，执行成功返回一个数组，数组元素代表某个命令的影响行数
        int[] effectRows = stmt.executeBatch();
        // 执行一条查询 SQL 语句，并返回结果集 ResultSet
        ResultSet resultSet = stmt.executeQuery("");
        // 获取当前结果集
        ResultSet resultSet1 = stmt.getResultSet();
        // 获取当前操作自增生成的主键
        ResultSet idKeys = stmt.getGeneratedKeys();
        // ...
    }

}
