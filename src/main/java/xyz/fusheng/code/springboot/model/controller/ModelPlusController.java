package xyz.fusheng.code.springboot.model.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.code.springboot.core.entity.PageVo;
import xyz.fusheng.code.springboot.model.core.service.IModelPlusService;
import xyz.fusheng.code.springboot.model.model.dto.ModelPlusPageDto;
import xyz.fusheng.code.springboot.model.model.dto.ModelPlusSaveDto;
import xyz.fusheng.code.springboot.model.model.dto.ModelPlusUpdateDto;
import xyz.fusheng.code.springboot.model.model.entity.ModelPlus;
import xyz.fusheng.code.springboot.model.model.vo.ModelPlusVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelPlusController
 * @date 2022-12-13 11:01:18
 */

@RestController
@RequestMapping("/modelPlus")
public class ModelPlusController {

    @Resource
    private IModelPlusService iModelPlusService;

    @PostMapping("/save")
    public void save(@RequestBody ModelPlusSaveDto saveDto) {
        ModelPlus modelPlus = new ModelPlus();
        BeanUtils.copyProperties(saveDto, modelPlus);
        iModelPlusService.save(modelPlus);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam List<Long> ids) {
        return iModelPlusService.removeBatchByIds(ids);
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody ModelPlusUpdateDto updateDto) {
        ModelPlus modelPlus = new ModelPlus();
        BeanUtils.copyProperties(updateDto, modelPlus);
        return iModelPlusService.updateById(modelPlus);
    }

    @GetMapping("/info/{id}")
    public ModelPlusVo info(@PathVariable Long id) {
        ModelPlusVo modelPlusVo = iModelPlusService.infoVo(id);
        return modelPlusVo;
    }

    @PostMapping("/pageVo")
    public PageVo<ModelPlusVo> pageVo(@RequestBody ModelPlusPageDto pageDto) {
        PageVo<ModelPlusVo> pageVo = iModelPlusService.pageVo(pageDto);
        return pageVo;
    }

}

