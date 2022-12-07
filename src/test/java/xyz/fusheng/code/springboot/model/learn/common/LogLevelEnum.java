package xyz.fusheng.code.springboot.model.learn.common;

import lombok.Getter;
import lombok.ToString;
import xyz.fusheng.code.springboot.core.enums.BaseEnum;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 日志级别枚举
 * @date 2022-12-06 21:02:08
 */

@Getter
@ToString
public enum LogLevelEnum implements BaseEnum<String> {

    FATAL("FATAL", "致命"),
    ERROR("ERROR", "错误"),
    WARN("WARN", "警告"),
    INFO("INFO", "信息"),
    DEBUG("DEBUG", "调试"),
    TRACE("TRACE","追踪")
    ;

    private final String code;
    private final String value;

    LogLevelEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

}