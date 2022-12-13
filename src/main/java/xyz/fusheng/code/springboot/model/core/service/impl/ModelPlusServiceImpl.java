package xyz.fusheng.code.springboot.model.core.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.fusheng.code.springboot.core.entity.PageVo;
import xyz.fusheng.code.springboot.model.core.mapper.ModelPlusMapper;
import xyz.fusheng.code.springboot.model.core.service.IModelPlusService;
import xyz.fusheng.code.springboot.model.model.dto.ModelPlusPageDto;
import xyz.fusheng.code.springboot.model.model.entity.ModelPlus;
import xyz.fusheng.code.springboot.model.model.vo.ModelPlusVo;

import javax.annotation.Resource;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelPlusServiceImpl
 * @date 2022-12-13 11:06:42
 */

@Service
public class ModelPlusServiceImpl extends ServiceImpl<ModelPlusMapper, ModelPlus> implements IModelPlusService {

    @Resource
    private ModelPlusMapper modelPlusMapper;

    @Override
    public ModelPlusVo infoVo(Long id) {
        ModelPlusVo modelPlusVo = modelPlusMapper.infoVo(id);
        return modelPlusVo;
    }

    @Override
    public PageVo<ModelPlusVo> pageVo(ModelPlusPageDto pageDto) {
        Page<ModelPlusVo> pageVo = modelPlusMapper.pageVo(pageDto.getPage(), pageDto);
        return new PageVo<>(pageVo);
    }

}

