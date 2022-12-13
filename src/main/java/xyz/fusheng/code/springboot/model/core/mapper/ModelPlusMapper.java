package xyz.fusheng.code.springboot.model.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.fusheng.code.springboot.model.model.dto.ModelPlusPageDto;
import xyz.fusheng.code.springboot.model.model.entity.ModelPlus;
import xyz.fusheng.code.springboot.model.model.vo.ModelPlusVo;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ModelPlusMapper
 * @date 2022-12-13 11:08:12
 */

@Mapper
public interface ModelPlusMapper extends BaseMapper<ModelPlus> {

    ModelPlusVo infoVo(@Param("id") Long id);

    Page<ModelPlusVo> pageVo(IPage<ModelPlusVo> page, @Param("pageDto") ModelPlusPageDto pageDto);
}

