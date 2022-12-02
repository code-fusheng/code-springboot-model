package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import xyz.fusheng.code.springboot.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统-角色表
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Getter
@Setter
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "系统-角色表")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("状态")
    @TableField("`status`")
    private Integer status;

    @ApiModelProperty("乐观锁 默认1")
    private Integer version;

}
