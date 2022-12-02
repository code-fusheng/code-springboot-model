package xyz.fusheng.code.springboot.model.model.dto;

import lombok.Data;
import xyz.fusheng.code.springboot.core.entity.LimitDto;
import xyz.fusheng.code.springboot.model.model.entity.Model;
import xyz.fusheng.code.springboot.model.model.vo.ModelVo;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelPageDto
 * @date 2022-12-01 15:52:01
 */

@Data
public class ModelPageDto extends LimitDto<Model> {

    private String modelName;

}

