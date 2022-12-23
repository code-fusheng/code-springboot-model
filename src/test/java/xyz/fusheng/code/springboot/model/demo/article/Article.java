package xyz.fusheng.code.springboot.model.demo.article;

import lombok.Data;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 文章类
 * @date 2022-12-22 10:26:09
 */

@Data
public class Article {

    private Long id;

    private String title;

    private String content;

}

