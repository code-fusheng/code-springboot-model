package xyz.fusheng.code.springboot.model.demo.article;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 字数文章过滤器
 * @date 2022-12-22 10:56:00
 */

public class WordCountArticleFilter extends BaseArticleFilter {

    @Override
    public boolean doFilter(ArticleContext articleContext) {
        Article article = articleContext.getArticle();
        // 执行字数过滤逻辑
        if (true) {
            sendNotify();
        }
        return false;
    }
}

