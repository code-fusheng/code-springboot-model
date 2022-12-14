package xyz.fusheng.code.springboot.model.tools.mysql;

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

        // ?????? SqlRunner ????????????????????? null????????????????????????????????? Null?????????????????????????????????????????????????????????
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
     * ?????? Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void descriptionConnection() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://rm-bp15mj67u7y8p5761lo.mysql.rds.aliyuncs.com:3306/test-mybatis?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8", "root", "zH1314520");
        // ???????????? Statement ???????????????????????? SQL ????????????????????????
        Statement statement = connection.createStatement();
        /** ???????????? CallableStatement ?????????????????????????????????????????? {@link ConnectionTest#testCallProcedure() } **/
        CallableStatement callableStatement = connection.prepareCall("");
        // ???????????? PreparedStatement ??????????????????????????????????????? SQL ????????????????????????
        PreparedStatement preparedStatement = connection.prepareStatement("", new String[]{});
        // ???????????? SQL ???????????????????????? SQL ??????
        String nativeSQL = connection.nativeSQL("");
        // ??????????????????
        connection.commit();
        // ??????????????????
        connection.rollback();
        // ???????????? Collection ??????
        connection.close();
        // ???????????? Connection ????????????
        boolean valid = connection.isValid(1000);
        // ?????? Connection ????????????????????????
        connection.setAutoCommit(true);
        // ??????/???????????? Connection ???????????????????????????
        connection.getTransactionIsolation();
        connection.setTransactionIsolation(Connection.TRANSACTION_NONE);
        // ???????????? Connection ??????????????????????????????????????????
        DatabaseMetaData metaData = connection.getMetaData();
    }

    /**
     * ????????????
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
     * ?????? Statement ??????
     */
    public void descriptionStatement() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        // ???????????? SQL ????????????????????? Statement ????????? SQL ??????????????????
        stmt.addBatch("");
        // ??????
        stmt.clearBatch();
        // ???????????? SQL
        boolean execute = stmt.execute("");
        // ?????????????????????????????????????????????????????????????????????????????????????????????????????????
        int[] effectRows = stmt.executeBatch();
        // ?????????????????? SQL ??????????????????????????? ResultSet
        ResultSet resultSet = stmt.executeQuery("");
        // ?????????????????????
        ResultSet resultSet1 = stmt.getResultSet();
        // ???????????????????????????????????????
        ResultSet idKeys = stmt.getGeneratedKeys();
        // ...
    }

}
