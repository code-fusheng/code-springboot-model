package xyz.fusheng.code.springboot.model.tools.orm.mybatis;

import lombok.extern.slf4j.Slf4j;
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

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc MybatisTest
 * @date 2022-12-05 10:39:33
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

}


