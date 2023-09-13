package xyz.fusheng.code.springboot.model.plugin.msg.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author code-fusheng
 * @since 2023-09-12
 */
@Getter
@Setter
@TableName("msg_channel")
@ApiModel(value = "MsgChannel对象", description = "")
public class MsgChannel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("消息渠道类型")
    private String channelType;

    @ApiModelProperty("渠道描述")
    private String channelDesc;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("是否启用(1:已启用/0:未启用)")
    private Integer isEnabled;

    @ApiModelProperty("是否逻辑删除(1:已删除/0:未删除)")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty("创建者编号")
    @TableField(fill = FieldFill.INSERT)
    private Long creatorId;

    @ApiModelProperty("修改者编号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updaterId;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("创建者姓名")
    @TableField(fill = FieldFill.INSERT)
    private String creatorName;

    @ApiModelProperty("修改者姓名")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updaterName;

    @ApiModelProperty("修改时间")
    private Date updatedAt;


    public static final String ID = "id";

    public static final String CHANNEL_TYPE = "channel_type";

    public static final String CHANNEL_DESC = "channel_desc";

    public static final String REMARK = "remark";

    public static final String IS_ENABLED = "is_enabled";

    public static final String IS_DELETED = "is_deleted";

    public static final String CREATOR_ID = "creator_id";

    public static final String UPDATER_ID = "updater_id";

    public static final String CREATED_AT = "created_at";

    public static final String CREATOR_NAME = "creator_name";

    public static final String UPDATER_NAME = "updater_name";

    public static final String UPDATED_AT = "updated_at";

}
