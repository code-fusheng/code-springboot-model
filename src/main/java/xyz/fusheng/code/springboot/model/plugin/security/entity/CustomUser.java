package xyz.fusheng.code.springboot.model.plugin.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.fusheng.code.springboot.core.enums.EnabledStatusEnum;

import java.util.Collection;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CustomUser
 * @date 2022-12-04 12:28:14
 */

@Data
public class CustomUser implements UserDetails {

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

    @ApiModelProperty("是否启用(1:启用/0:禁用)")
    private EnabledStatusEnum isEnabled;

    @ApiModelProperty("用户角色")
    private Collection<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled == EnabledStatusEnum.DISABLED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled == EnabledStatusEnum.ENABLED;
    }
}

