package xyz.fusheng.code.springboot.model.model.vo;

import lombok.Data;
import xyz.fusheng.code.springboot.model.model.entity.Model;

import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelVo
 * @date 2022-12-01 15:49:51
 */

@Data
public class ModelVo extends Model {

    private String extendStr;

    private List<Model> modelList;
    
}

