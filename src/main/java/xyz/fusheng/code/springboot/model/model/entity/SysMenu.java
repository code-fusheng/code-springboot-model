package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import xyz.fusheng.code.springboot.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统-权限表
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Getter
@Setter
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "系统-权限表")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("权限名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("权限标识")
    private String permission;

    @ApiModelProperty("权限路由")
    @TableField("`path`")
    private String path;

    @ApiModelProperty("父级id")
    private Long pid;

    @ApiModelProperty("权限级别 1 菜单 2 列表 3 接口")
    @TableField("`level`")
    private Integer level;

    @ApiModelProperty("状态")
    @TableField("`status`")
    private Integer status;

    @ApiModelProperty("乐观锁 默认1")
    private Integer version;

}
