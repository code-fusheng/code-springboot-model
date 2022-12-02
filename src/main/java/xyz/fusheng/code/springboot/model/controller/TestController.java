package xyz.fusheng.code.springboot.model.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fusheng.code.springboot.core.annotaion.NoBodyAdvice;
import xyz.fusheng.code.springboot.core.entity.ResultVo;
import xyz.fusheng.code.springboot.core.exception.BusinessException;
import xyz.fusheng.code.springboot.model.core.mapper.ModelMapper;
import xyz.fusheng.code.springboot.model.model.entity.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TestController
 * @date 2022-12-01 09:18:54
 */

@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
public class TestController {

    @Resource
    private ModelMapper modelMapper;

    @PostMapping("/rt0")
    public List<Model> rt0() {
        return modelMapper.selectList(null);
    }

    @PostMapping("/rt1")
    public ResultVo<List<Model>> rt1() {
        return ResultVo.success(modelMapper.selectList(null));
    }

    @PostMapping("/rt2")
    @NoBodyAdvice
    public List<Model> rt2() {
        return modelMapper.selectList(null);
    }

    @PostMapping("/rt3")
    public void rt3() {

    }

    @PostMapping("/exp0")
    public String exp0() {
        throw new BusinessException("测试异常");
    }

    @PostMapping("/exp1")
    public void exp1() {
        throw new BusinessException("测试异常");
    }

    @PostMapping("/exp2")
    public void exp2() {
        throw new RuntimeException("测试");
    }
    
}

