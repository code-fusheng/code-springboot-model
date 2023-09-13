package xyz.fusheng.code.springboot.model.tools.office.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.fusheng.code.springboot.model.plugin.office.excel.model.ModelExcel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @FileName: EasyExcelTest
 * @Author: code-fusheng
 * @Date: 2022/6/23 11:24
 * @Version: 1.0
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class EasyExcelWriteTest {

    /**
     * EasyExcel 单次写入测试
     *
     * @throws IOException
     */
    @Test
    public void testEasyExcelSimpleWrite() throws IOException {
        File file = new File(Paths.get("testEasyExcelSingleWrite.xlsx").toString());
        List<ModelExcel> modelExcelList = IntStream.rangeClosed(1, 200000).mapToObj(i -> {
            ModelExcel modelExcel = new ModelExcel();
            return modelExcel;
        }).collect(Collectors.toList());
        EasyExcel.write(file.getPath(), ModelExcel.class).sheet("test").doWrite(modelExcelList);
    }

    /**
     * EasyExcel 多次写入测试
     *
     * @throws IOException
     */
    @Test
    public void testEasyExcelReWrite() throws IOException {
        File file = new File(Paths.get("testEasyExcelReWrite.xlsx").toString());
        ExcelWriter excelWriter = EasyExcel.write(file.getPath(), ModelExcel.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
        for (int i = 0; i < 5; i++) {
            List<ModelExcel> modelExcelList = IntStream.rangeClosed(1, 200).mapToObj(item -> {
                ModelExcel modelExcel = new ModelExcel();
                return modelExcel;
            }).collect(Collectors.toList());
            excelWriter.write(modelExcelList, writeSheet);
        }
        // 将内存中的数据刷写到文件
        excelWriter.finish();
    }

}
