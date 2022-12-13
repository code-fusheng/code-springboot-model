package xyz.fusheng.code.springboot.model.plugin.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import xyz.fusheng.code.springboot.core.config.BaseMybatisPlusConfig;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;
import xyz.fusheng.code.springboot.model.plugin.security.util.UserInfoContextHolder;

import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc MybatisPlusConfig
 * @date 2022-12-13 15:17:53
 */

@Primary
@Configuration
public class MybatisPlusConfig extends BaseMybatisPlusConfig {

    @Override
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        return super.mybatisPlusInterceptor();
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        super.insertFill(metaObject);
        CustomUser userInfo = UserInfoContextHolder.getCurrentUserInfo();
        if (!Objects.isNull(userInfo)) {
            this.strictInsertFill(metaObject, "creatorId", Long.class, userInfo.getId());
            this.strictInsertFill(metaObject, "creatorName", String.class, userInfo.getUsername());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        super.updateFill(metaObject);
        CustomUser userInfo = UserInfoContextHolder.getCurrentUserInfo();
        if (!Objects.isNull(userInfo)) {
            this.strictInsertFill(metaObject, "updaterId", Long.class, userInfo.getId());
            this.strictInsertFill(metaObject, "updaterName", String.class, userInfo.getUsername());
        }
    }
}

