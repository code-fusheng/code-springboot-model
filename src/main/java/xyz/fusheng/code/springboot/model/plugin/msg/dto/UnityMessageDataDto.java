package xyz.fusheng.code.springboot.model.plugin.msg.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @FileName: UnityMessageDataDto
 * @Author: code-fusheng
 * @Date: 2022/1/11 5:42 下午
 * @Version: 1.0
 * @Description: 统一消息通知数据体
 */

@Data
public class UnityMessageDataDto {

    @ApiModelProperty(value = "统一消息参数 JSONObject")
    private Object unityMsgParams;

}
