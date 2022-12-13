package xyz.fusheng.code.springboot.model.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.ToString;
import xyz.fusheng.code.springboot.core.entity.BaseEntity;

import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelPlus 强化模版对象
 * @date 2022-12-13 10:58:01
 */

@Data
@ToString
@TableName(value = "code_model_plus")
public class ModelPlus extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String modelPlusName;

    private String modelPlusImage;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> modelPlusTags;

}

