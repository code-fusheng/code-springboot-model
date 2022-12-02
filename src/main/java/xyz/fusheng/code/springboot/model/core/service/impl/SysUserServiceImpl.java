package xyz.fusheng.code.springboot.model.core.service.impl;

import xyz.fusheng.code.springboot.model.model.entity.SysUser;
import xyz.fusheng.code.springboot.model.core.mapper.SysUserMapper;
import xyz.fusheng.code.springboot.model.core.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统-用户表 服务实现类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
