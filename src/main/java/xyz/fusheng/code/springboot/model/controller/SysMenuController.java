package xyz.fusheng.code.springboot.model.controller;

import io.swagger.annotations.Api;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fusheng.code.springboot.model.common.util.ApplicationContextHolder;
import xyz.fusheng.code.springboot.model.core.service.ISysMenuService;
import xyz.fusheng.code.springboot.model.core.service.impl.SysMenuServiceImpl;

import javax.annotation.Resource;

/**
 * <p>
 * 系统-权限表 前端控制器
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@RestController
@RequestMapping("/sysMenu")
@Api(tags = "系统菜单模块")
public class SysMenuController {

    @Resource
    private ISysMenuService iSysMenuService;

    @PostMapping("/sync")
    public Object sync() {
         return iSysMenuService.sync();
    }

}
