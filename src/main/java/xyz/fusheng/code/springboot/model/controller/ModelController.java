package xyz.fusheng.code.springboot.model.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.code.springboot.model.core.mapper.ModelMapper;
import xyz.fusheng.code.springboot.model.core.service.IModelService;
import xyz.fusheng.code.springboot.model.model.dto.ModelPageDto;
import xyz.fusheng.code.springboot.model.model.dto.ModelSaveDto;
import xyz.fusheng.code.springboot.model.model.entity.Model;
import xyz.fusheng.code.springboot.model.model.vo.ModelVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author code-fusheng
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/model")
@Api(tags = "模版模块")
public class ModelController {

    @Resource
    private IModelService modelService;

    @Resource
    private ModelMapper modelMapper;

    @PostMapping("/save")
    @ApiOperation(value = "添加")
    public Boolean save(@RequestBody ModelSaveDto saveDto) {
        Model model = new Model();
        BeanUtils.copyProperties(saveDto, model);
        return modelService.save(model);
    }

    @PostMapping("/page1")
    public Page<Model> page1(@RequestBody ModelPageDto pageDto) {
        IPage<Model> iPage = modelService.getBaseMapper().selectPage(pageDto.getPage(), null);
        Page<Model> page = new Page<>();
        page.setRecords(iPage.getRecords());
        page.setTotal(iPage.getTotal());
        return page;
    }

    @PostMapping("/page2")
    public Page<Model> page2(@RequestBody ModelPageDto pageDto) {
        Page<Model> page = modelMapper.customPage(pageDto.getPage(), pageDto);
        return page;
    }

    @PostMapping("/deletes")
    @ApiOperation(value = "删除")
    public void deletes(@RequestBody List<String> ids) {
        modelMapper.deleteBatchIds(ids);
    }

    @GetMapping("/info/{id}")
    @ApiOperation(value = "查看详情")
    public ModelVo info(@PathVariable("id") String id) {
        ModelVo modelVo = new ModelVo();
        Model model = modelMapper.selectById(id);
        BeanUtils.copyProperties(model, modelVo);
        return modelVo;
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Boolean update(@RequestBody Model model) {
        return SqlHelper.retBool(modelMapper.updateById(model));
    }

    @GetMapping("/infoVo/{id}")
    public ModelVo infoVo(@PathVariable("id") String id) {
        ModelVo modelVo = modelMapper.selectVoById(id);
        return modelVo;
    }

}
