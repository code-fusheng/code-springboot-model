package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import xyz.fusheng.code.springboot.core.entity.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author code-fusheng
 * @since 2022-11-29
 */
@Getter
@Setter
@TableName("code_model")
@ApiModel(value = "Model对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Model extends BaseEntity {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("模版名称")
    private String modelName;

}
