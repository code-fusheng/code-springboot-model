package xyz.fusheng.code.springboot.model.core.mapper;

import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import xyz.fusheng.code.springboot.model.model.entity.SysRole;
import xyz.fusheng.code.springboot.model.model.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统-用户表 Mapper 接口
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysRole> selectRoleByUserId(Long uid);

    List<SysMenu> selectMenuByUserId(Long uid);

}
