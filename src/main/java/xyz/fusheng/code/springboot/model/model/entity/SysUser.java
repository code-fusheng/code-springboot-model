package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import xyz.fusheng.code.springboot.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统-用户表
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "系统-用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("唯一ID")
    private String uuid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    @TableField("`password`")
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("电话号码")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String mail;

    @ApiModelProperty("签名")
    private String signature;

    @ApiModelProperty("描述")
    @TableField("`description`")
    private String description;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("性别 0:私密 1:男 2:女")
    private Integer sex;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("经度")
    private BigDecimal lng;

    @ApiModelProperty("纬度")
    private BigDecimal lat;

    @ApiModelProperty("状态")
    @TableField("`status`")
    private Integer status;

    @ApiModelProperty("乐观锁 默认1")
    private Integer version;

}
