package xyz.fusheng.code.springboot.model.demo.article;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 基础文章过滤器
 * @date 2022-12-22 10:44:53
 */

public abstract class BaseArticleFilter implements IArticleFilter {

    void sendNotify() {
        // 发送通知的逻辑
    }

}

