package xyz.fusheng.code.springboot.model.tools.office.excel;

import com.alibaba.excel.EasyExcel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.fusheng.code.springboot.model.plugin.office.excel.listener.CompanyReadListener;
import xyz.fusheng.code.springboot.model.plugin.office.excel.model.CompanyReadExcel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: EasyExcelReadTest
 * @Author: code-fusheng
 * @Date: 2022/7/3 10:08
 * @Version: 1.0
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class EasyExcelReadTest {

    @Autowired
    private ObjectMapper objectMapper;

    // 公司宝 营商云 索引
    private static final String COMPANY_INDEX = "gsb_zq_company_index_";

    @Test
    public void testEasyExcelSimpleRead() throws IOException {
        List<File> fileList = new ArrayList<>();
        // 朝科创
        //File file1 = new File(Paths.get("1-第二届“凤鸣计划”名单-改.xlsx").toString());
        //fileList.add(file1);
        //File file2 = new File(Paths.get("2-独角兽企业-改.xls").toString());
        //fileList.add(file2);
        //File file3 = new File(Paths.get("3-高新技术企业-改.xls").toString());
        //fileList.add(file3);
        //File file4 = new File(Paths.get("4-科技型中小企业-改.xls").toString());
        //fileList.add(file4);
        //File file5 = new File(Paths.get("5-专精特新企业-改.xls").toString());
        //fileList.add(file5);
        //File file6 = new File(Paths.get("6-专精特新小巨人企业-改.xls").toString());
        //fileList.add(file6);
        //File file7 = new File(Paths.get("7-独角兽、未来独角兽企业名单_20220703164604-改.xlsx").toString());
        //fileList.add(file7);
        //File file8 = new File(Paths.get("8-朝阳园中关村高新技术企业（截止2022年4月）-改.xlsx").toString());
        //fileList.add(file8);
        //File file9 = new File(Paths.get("9-朝阳区2021年高新企业总表（不含联系方式）-改.xlsx").toString());
        //fileList.add(file9);

        // 海口市秀英区
        //File file10 = new File(Paths.get("1-专精特新小巨人企业.xls").toString());
        //fileList.add(file10);
        //File file11 = new File(Paths.get("2-秀英高新技术企业.xls").toString());
        //fileList.add(file11);
        //File file12 = new File(Paths.get("3-海南科技中小型企业.xls").toString());
        //fileList.add(file12);
        //File file13 = new File(Paths.get("4-瞪羚企业海南.xls").toString());
        //fileList.add(file13);
        //File file14 = new File(Paths.get("5-海南专精特新中小企业.xls").toString());
        //fileList.add(file14);

        // 智子空间
        File file15 = new File(Paths.get("副本中新生态大厦_科技型中小企业.xls").toString());
        fileList.add(file15);
        File file16 = new File(Paths.get("副本中新生态大厦_高新技术企业.xls").toString());
        fileList.add(file16);
        fileList.forEach(file -> {
            EasyExcel.read(file, CompanyReadExcel.class, new CompanyReadListener(COMPANY_INDEX, objectMapper)).sheet().headRowNumber(1).doRead();
        });

    }

}
