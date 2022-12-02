package xyz.fusheng.code.springboot.model.core.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fusheng.code.springboot.model.common.util.ApplicationContextHolder;
import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import xyz.fusheng.code.springboot.model.core.mapper.SysMenuMapper;
import xyz.fusheng.code.springboot.model.core.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.fusheng.code.springboot.model.model.vo.SysMenuTreeVo;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 * 系统-权限表 服务实现类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */

@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private ApplicationContextHolder applicationContextHolder;

    @Override
    public Object sync() {
        return buildMenuTree();
    }

    private Object buildMenuTree() {
        ApplicationContext applicationContext = applicationContextHolder.getApplicationContext();
        List<SysMenu> allMenu = new ArrayList<>();
        List<SysMenu> menuTree = new ArrayList<>();
        List<SysMenu> childSysMenu = new ArrayList<>();
        Long rootMenuId = 0L;
        Map<String, Object> controllers = applicationContext.getBeansWithAnnotation(RestController.class);
        for (Map.Entry<String, Object> controller : controllers.entrySet()) {
            rootMenuId ++;
            SysMenuTreeVo rootMenuVo = new SysMenuTreeVo();
            SysMenu rootMenu = new SysMenu();
            childSysMenu = new ArrayList<>();
            Long childMenuId = 0L;
            Object value = controller.getValue();
            log.info("controller:{} - value:{}", controller.getKey(), value);
            Class<?> aClass = AopUtils.getTargetClass(value);
            RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
            Api api = aClass.getAnnotation(Api.class);
            // Controller 接口注解 => 一级权限 路径 /**
            rootMenu.setId(rootMenuId * 1000);
            rootMenu.setName(Objects.isNull(api) ? "" : api.tags()[0]);
            rootMenu.setPath(Objects.isNull(requestMapping) ? "" : requestMapping.value()[0]);
            rootMenu.setPid(0L);
            rootMenu.setLevel(1);
            allMenu.add(rootMenu);
            // 子级菜单
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                childMenuId ++;
                SysMenu childMenu = new SysMenu();
                childMenu.setId(rootMenu.getId() + childMenuId);
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof PostMapping) {
                        log.info("post:{}", ((PostMapping) annotation).value()[0]);
                        childMenu.setPath(rootMenu.getPath() + ((PostMapping) annotation).value()[0]);
                    }
                    if (annotation instanceof GetMapping) {
                        log.info("get:{}", ((GetMapping) annotation).value()[0]);
                        childMenu.setPath(rootMenu.getPath() + ((GetMapping) annotation).value()[0]);
                    }
                }
                ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
                childMenu.setName(Objects.isNull(apiOperation) ? "" : apiOperation.value());
                childMenu.setPid(rootMenu.getId());
                childMenu.setLevel(2);
                childSysMenu.add(childMenu);
            }
            allMenu.addAll(childSysMenu);
            BeanUtils.copyProperties(rootMenu, rootMenuVo);
            rootMenuVo.setChildMenu(childSysMenu);
            menuTree.add(rootMenuVo);
        }
        saveBatch(allMenu);
        return menuTree;
    }

}
