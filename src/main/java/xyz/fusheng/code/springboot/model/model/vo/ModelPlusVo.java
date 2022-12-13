package xyz.fusheng.code.springboot.model.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import xyz.fusheng.code.springboot.model.model.entity.ModelPlus;

import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelPlusVo
 * @date 2022-12-13 11:00:15
 */

@Data
public class ModelPlusVo extends ModelPlus {

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> strList;

}

