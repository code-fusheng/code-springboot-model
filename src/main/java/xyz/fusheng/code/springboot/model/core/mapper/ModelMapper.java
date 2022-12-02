package xyz.fusheng.code.springboot.model.core.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import xyz.fusheng.code.springboot.model.model.dto.ModelPageDto;
import xyz.fusheng.code.springboot.model.model.entity.Model;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.fusheng.code.springboot.model.model.vo.ModelVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author code-fusheng
 * @since 2022-11-29
 */
@Mapper
public interface ModelMapper extends BaseMapper<Model> {

    Page<Model> customPage(@Param("page") IPage<Model> page, @Param("pageDto") ModelPageDto pageDto);

}
