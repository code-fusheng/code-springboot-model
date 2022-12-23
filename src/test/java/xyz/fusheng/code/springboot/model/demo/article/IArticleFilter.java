package xyz.fusheng.code.springboot.model.demo.article;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 文章过滤器接口
 * @date 2022-12-22 10:42:42
 */

public interface IArticleFilter {

    boolean doFilter(ArticleContext articleContext);

    // 支持方法扩展

}

