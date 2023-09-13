package xyz.fusheng.code.springboot.model.plugin.msg.dto;

import lombok.Data;

/**
 * @FileName: UnityMessageReciverDto
 * @Author: code-fusheng
 * @Date: 2022/1/11 9:24 上午
 * @Version: 1.0
 * @Description: 统一接收者数据传输包
 */

@Data
public class UnityMessageReceiverDto {

    private String userId;

    private String mobile;

    private String openid;

    private String email;

    private String licencePlate;

}
