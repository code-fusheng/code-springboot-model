package xyz.fusheng.code.springboot.model.tools.orm.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.fusheng.code.springboot.model.core.mapper.ModelMapper;
import xyz.fusheng.code.springboot.model.core.mapper.SysUserMapper;
import xyz.fusheng.code.springboot.model.model.entity.Model;
import xyz.fusheng.code.springboot.model.model.entity.SysUser;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc MybatisTest
 * @date 2022-12-05 10:39:33
 *
 *
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisTest {

    private SqlSession session;

    @PostConstruct
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);
        // 配置信息读取
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void testMybatis() throws IOException {

        SysUserMapper userMapper = session.getMapper(SysUserMapper.class);
        SysUser userParams = new SysUser();
        userParams.setUsername("code-fusheng");

        // SysUser user1 = userMapper.selectUserByUsername("code-fusheng");
        // log.info("user1:{}", user1);

        // SysUser user2 = userMapper.selectUserList(1L, "code-fusheng");
        // log.info("user2:{}", user2);

    }

    /**
     * SQL 片段
     */
    @Test
    public void testMybatisSqlFragment() {
        ModelMapper modelMapper = session.getMapper(ModelMapper.class);
        Model model = modelMapper.selectModelByModelName("test");
        log.info("model:{}", model);
    }

    @Test
    public void testMybatisScripting() {
        Model model = new Model();
        model.setId(1L);
        model.setModelName("test");

        ModelMapper modelMapper = session.getMapper(ModelMapper.class);
        Model modelResult = modelMapper.selectModelByIdOrModelName(model);
        log.info("modelResult:{}", modelResult);
    }

    @Test
    public void testLogging() {
        // 是否开启 Trace
        System.out.println(log.isTraceEnabled());
    }

    /**
     * 测试使用 Mybatis 游标查询
     */
    @Test
    public void testMybatisCursor() {
        ModelMapper modelMapper = session.getMapper(ModelMapper.class);
        Cursor<Model> modelCursor = modelMapper.selectModelsRegexpName("test");
        for (Model model : modelCursor) {
            log.info("model:{}", model);
        }
    }

    @Test
    public void testMybatisIdGenerator() {
        ModelMapper modelMapper = session.getMapper(ModelMapper.class);
        Model model = new Model();
        model.setModelName("testId-Generator");
        modelMapper.insertModel(model);
        log.info("model1:{}", model);
    }


    /**
     * · STATEMENT：这种语句类型中，只会对 SQL片段进行简单的字符串拼接。因此，只支持使用“${}”定义变量。 ${} 必须自己添加引号 如: "${modelName}"
     * · PREPARED：这种语句类型中，会先对 SQL片段进行字符串拼接，然后对 SQL片段进行赋值。因此，支持使用“${}”“＃{}”这两种形式定义变量。    会把变量转化为 ？ 后填入，不能有引号
     * · CALLABLE：这种语句类型用来实现执行过程的调用，会先对 SQL 片段进行字符串拼接，然后对 SQL片段进行赋值。因此，支持使用“${}”“＃{}”这两种形式定义变量。
     */
    @Test
    public void testStatementForCallable() {
        ModelMapper modelMapper = session.getMapper(ModelMapper.class);
        String modelName = "test";
        List<Model> modelList = modelMapper.runCall(modelName);
        log.info("modelList:{}", modelList);
    }

    /**
     * 测试 Mybatis 多结果集处理
     * PS：UNION 虽然结果集中的结果明显被分为两类，但仍然属于一个结果集
     * 通过编写存储过程脚本可以实现返回多结果集
     * CREATE PROCEDURE learn_multi_results()
     * BEGIN
     * 	SELECT id, model_name FROM code_model WHERE id > 1;
     * 	SELECT id, model_name FROM code_model WHERE model_name = 'test';
     * END
     */
    @Test
    public void testMultiResultSet() {
        ModelMapper modelMapper = session.getMapper(ModelMapper.class);
        List<Model> models = modelMapper.testMultiResults();
        log.info("models:{}", models);
    }

}


