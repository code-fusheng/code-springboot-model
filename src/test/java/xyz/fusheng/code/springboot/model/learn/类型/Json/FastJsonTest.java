package xyz.fusheng.code.springboot.model.learn.类型.Json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @FileName: FastJsonTest
 * @Author: code-fusheng
 * @Date: 2022/8/2 09:57
 * @Version: 1.0
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FastJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(FastJsonTest.class);

    /**
     * 对象属性命名不规范问题处理
     */
    @Test
    public void testFastJsonConvertError() throws JsonProcessingException {
        Obj1 obj1 = new Obj1();
        obj1.setTEST("TEST");
        obj1.setIPhone("iPhone");
        obj1.setT_EST("T_EST");
        Object json = JSON.toJSON(obj1);
        logger.info("{}", json);
        String s = objectMapper.writeValueAsString(obj1);
        logger.info("TEST:{}", s);
    }

}

@Data
class Obj1 {

    private String iPhone;

    private String TEST;

    private String T_EST;

}
