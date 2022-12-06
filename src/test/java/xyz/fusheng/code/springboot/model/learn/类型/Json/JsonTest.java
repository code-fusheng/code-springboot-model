package xyz.fusheng.code.springboot.model.learn.类型.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @FileName: JsonTest
 * @Author: code-fusheng
 * @Date: 2022/6/13 14:50
 * @Version: 1.0
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonTest.class);

    private static void testNullJson() {
        JSONObject memoJson1 = JSON.parseObject("", JSONObject.class);
        System.out.println(memoJson1);

        JSONObject memoJson2 = Optional.ofNullable(JSON.parseObject(null, JSONObject.class)).orElse(new JSONObject());
        System.out.println(memoJson2);
    }

    private static void testFileJson() {
        char[] chars = new char[10];
        String content = "";
        try (FileInputStream fileInputStream = new FileInputStream("voucherData-1.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {
            int count;
            while ((count = inputStreamReader.read(chars)) != -1) {
                content += new String(chars, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonData = JSON.parseObject(content, JSONObject.class);
        logger.info("content:{}", JSON.toJSONString(jsonData));
    }

    @Test
    public void testTypeReference() {
        List<Test1> list1 = new ArrayList<>();
        Test2 test2_1 = new Test2("desc", new ArrayList<String>() {{
            add("x");
        }});
        list1.add(new Test1(1, "A", test2_1));
        logger.info("list1:{}", list1);
        String str = JSON.toJSONString(list1);
        logger.info("str:{}", str);
        List<Test1> list2 = JSON.parseObject(str, new TypeReference<List<Test1>>() {
        });
        logger.info("list2:{}", list2);
        List<Test1> list3 = JSON.parseArray(str, Test1.class);
        logger.info("list3:{}", list3);
    }

    public static void main(String[] args) {
        //testNullJson();
        //testFileJson();
    }

}
