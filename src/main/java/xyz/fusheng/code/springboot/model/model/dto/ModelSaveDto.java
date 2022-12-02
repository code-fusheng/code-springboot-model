package xyz.fusheng.code.springboot.model.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Model 添加 Dto
 * @date 2022-12-01 09:38:25
 */

@Data
public class ModelSaveDto {

    @ApiModelProperty(value = "模版名称")
    private String modelName;
    
}

