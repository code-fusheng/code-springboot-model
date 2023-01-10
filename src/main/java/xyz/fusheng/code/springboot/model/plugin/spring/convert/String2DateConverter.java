package xyz.fusheng.code.springboot.model.plugin.spring.convert;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc String 2 Date 类型转换器
 * @date 2022-12-23 17:49:12
 */

public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        try {
            return DateUtils.parseDate(s, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}

