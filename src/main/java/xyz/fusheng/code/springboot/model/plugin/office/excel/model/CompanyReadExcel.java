package xyz.fusheng.code.springboot.model.plugin.office.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @FileName: CompanyExcel
 * @Author: code-fusheng
 * @Date: 2022/7/3 12:37
 * @Version: 1.0
 * @Description:
 */

@Data
public class CompanyReadExcel {

    @ExcelProperty(index = 0)
    private String companyName;

    @ExcelProperty(index = 1)
    private String companyTag;

}
