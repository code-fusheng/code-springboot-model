package xyz.fusheng.code.springboot.model.plugin.msg.dto;

import lombok.Data;

/**
 * @FileName: SmsResultDto
 * @Author: code-fusheng
 * @Date: 2022/8/9 11:27
 * @Version: 1.0
 * @Description:
 */

@Data
public class SendResultDto {

    private boolean success;

    private String resultText;

    private String fillReason;

}
