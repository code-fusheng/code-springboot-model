package xyz.fusheng.code.springboot.model.plugin.msg.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @FileName: UnityMessageDto
 * @Author: code-fusheng
 * @Date: 2022/1/10 5:55 下午
 * @Version: 1.0
 * @Description:
 */

@Data
@ApiModel("统一消息传输对象")
public class UnityMessageDto {

    @ApiModelProperty("短信模版Id")
    private String smsId;

    @ApiModelProperty("平台模版Id")
    private String ptMsgId;

    @ApiModelProperty("微信消息Id")
    private String wxMsgId;

    @ApiModelProperty(value = "消息接收方")
    private UnityMessageReceiverDto messageReceiver;

    @ApiModelProperty(value = "应用Id")
    private String appId;

    /**
     * {@link com.alibaba.fastjson.JSONObject}
     */
    @ApiModelProperty(value = "消息体")
    private UnityMessageDataDto data;

}
