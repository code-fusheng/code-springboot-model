package xyz.fusheng.code.springboot.model.plugin.msg.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("msg_send_record")
@ApiModel(value = "MsgSendRecord对象", description = "")
public class MsgSendRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("消息模版ID")
    private String templateId;

    @ApiModelProperty("消息模版描述")
    private String templateDesc;

    @ApiModelProperty("消息渠道类型")
    private String channelType;

    @ApiModelProperty("消息标题")
    private String msgTitle;

    @ApiModelProperty("消息内容")
    private String msgContent;

    @ApiModelProperty("相关参数")
    private String refParams;

    @ApiModelProperty("请求响应")
    private String apiResponse;

    @ApiModelProperty("结果")
    private String result;

    @ApiModelProperty("发送时间")
    private Date sendTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者编号")
    @TableField(fill = FieldFill.INSERT)
    private Long creatorId;

    @ApiModelProperty("修改者编号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updaterId;

    @ApiModelProperty("创建者姓名")
    @TableField(fill = FieldFill.INSERT)
    private String creatorName;

    @ApiModelProperty("修改者姓名")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updaterName;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("修改时间")
    private Date updatedAt;

    @ApiModelProperty("车场ID")
    private Long parkId;

    @ApiModelProperty("接收者类型")
    private String receiverType;

    @ApiModelProperty("接受者ID")
    private String receiverKey;


    public static final String ID = "id";

    public static final String TEMPLATE_ID = "template_id";

    public static final String TEMPLATE_DESC = "template_desc";

    public static final String CHANNEL_TYPE = "channel_type";

    public static final String MSG_TITLE = "msg_title";

    public static final String MSG_CONTENT = "msg_content";

    public static final String REF_PARAMS = "ref_params";

    public static final String API_RESPONSE = "api_response";

    public static final String RESULT = "result";

    public static final String SEND_TIME = "send_time";

    public static final String REMARK = "remark";

    public static final String CREATOR_ID = "creator_id";

    public static final String UPDATER_ID = "updater_id";

    public static final String CREATOR_NAME = "creator_name";

    public static final String UPDATER_NAME = "updater_name";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String PARK_ID = "park_id";

    public static final String RECEIVER_TYPE = "receiver_type";

    public static final String RECEIVER_KEY = "receiver_key";

}
