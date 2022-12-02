package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import xyz.fusheng.code.springboot.core.entity.BaseEntity;
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
 * @since 2022-11-29
 */
@Getter
@Setter
@TableName("code_model")
@ApiModel(value = "Model对象", description = "")
public class Model extends BaseEntity {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("模版名称")
    private String modelName;

}
