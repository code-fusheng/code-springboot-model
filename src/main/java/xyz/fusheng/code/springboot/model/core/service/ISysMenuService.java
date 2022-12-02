package xyz.fusheng.code.springboot.model.core.service;

import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统-权限表 服务类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
public interface ISysMenuService extends IService<SysMenu> {

    Object sync();

}
