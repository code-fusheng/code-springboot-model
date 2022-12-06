package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Model extends BaseEntity {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("模版名称")
    private String modelName;

}
