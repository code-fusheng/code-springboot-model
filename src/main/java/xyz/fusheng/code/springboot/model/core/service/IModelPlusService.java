package xyz.fusheng.code.springboot.model.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.fusheng.code.springboot.core.entity.PageVo;
import xyz.fusheng.code.springboot.model.model.dto.ModelPlusPageDto;
import xyz.fusheng.code.springboot.model.model.entity.ModelPlus;
import xyz.fusheng.code.springboot.model.model.vo.ModelPlusVo;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc IModelPlusService
 * @date 2022-12-13 11:06:01
 */

public interface IModelPlusService extends IService<ModelPlus> {

    ModelPlusVo infoVo(Long id);

    PageVo<ModelPlusVo> pageVo(ModelPlusPageDto pageDto);

}