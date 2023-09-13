package xyz.fusheng.code.springboot.model.plugin.office.excel.listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.fusheng.code.springboot.model.plugin.office.excel.model.CompanyReadExcel;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @FileName: CompanyReadListener
 * @Author: code-fusheng
 * @Date: 2022/7/3 12:41
 * @Version: 1.0
 * @Description:
 */

public class CompanyReadListener implements ReadListener<CompanyReadExcel> {

    private static final Logger logger = LoggerFactory.getLogger(CompanyReadListener.class);

    public static final ThreadLocal<AtomicInteger> count = ThreadLocal.withInitial(() ->
            new AtomicInteger(0));

    public static final ThreadLocal<List<CompanyReadExcel>> noMatchCompanyList = ThreadLocal.withInitial(ArrayList::new);

    private String COMPANY_INDEX;

    private ObjectMapper objectMapper;

    public CompanyReadListener(String COMPANY_INDEX, ObjectMapper objectMapper) {
        this.COMPANY_INDEX = COMPANY_INDEX;
        this.objectMapper = objectMapper;
    }

    @Override
    public void invoke(CompanyReadExcel companyReadExcel, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        logger.info("[解析Excel数据-完成所有]");
        File file = new File(Paths.get("未匹配企业-" + System.currentTimeMillis() + ".xlsx").toString());
        EasyExcel.write(file.getPath(), CompanyReadExcel.class).sheet("test").doWrite(noMatchCompanyList.get());
    }
}
