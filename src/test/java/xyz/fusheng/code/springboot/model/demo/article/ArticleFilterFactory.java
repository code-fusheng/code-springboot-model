package xyz.fusheng.code.springboot.model.demo.article;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 文章过滤器工厂
 * @date 2022-12-22 10:59:09
 */

public class ArticleFilterFactory {

    private ArticleFilterFactory() {}

    public static List<IArticleFilter> createArticleFilter(List<ArticleFilterEnum> articleFilterEnumList) {
        List<IArticleFilter> articleFilterList = null;
        if (CollectionUtils.isEmpty(articleFilterEnumList)) {
            articleFilterList = articleFilterEnumList.stream().map(
                    ArticleFilterFactory::createFilter
            ).collect(Collectors.toList());
        }
        return articleFilterList;
    }

    private static IArticleFilter createFilter(ArticleFilterEnum articleFilterEnum) {
        IArticleFilter iArticleFilter = null;
        switch (articleFilterEnum) {
            case WORD_COUNT:
                iArticleFilter = new WordCountArticleFilter();
                break;
            default:
                break;
        }
        return iArticleFilter;
    }

}

