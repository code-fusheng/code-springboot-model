package xyz.fusheng.code.springboot.model.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import xyz.fusheng.code.springboot.model.model.entity.SysMenu;

import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 权限树🌲
 * @date 2022-12-02 10:23:48
 */

@Data
@ApiModel(value = "系统权限树")
public class SysMenuTreeVo extends SysMenu {

    @ApiModelProperty(value = "子级权限")
    private List<SysMenu> childMenu;

}

