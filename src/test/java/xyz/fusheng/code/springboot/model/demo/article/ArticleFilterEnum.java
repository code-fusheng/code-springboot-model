package xyz.fusheng.code.springboot.model.demo.article;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import xyz.fusheng.code.springboot.core.enums.BaseEnum;
import xyz.fusheng.code.springboot.model.demo.pay.PayChannelEnum;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 文章过滤器枚举
 * @date 2022-12-22 10:27:17
 */

@Getter
public enum ArticleFilterEnum implements BaseEnum<String> {

    WORD_COUNT("word_count", "字数统计"),

    ;

    private String code;

    private String value;

    ArticleFilterEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ArticleFilterEnum of(String code) {
        return BaseEnum.of(ArticleFilterEnum.class, code);
    }

}