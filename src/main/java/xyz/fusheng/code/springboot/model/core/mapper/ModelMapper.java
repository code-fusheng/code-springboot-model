package xyz.fusheng.code.springboot.model.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;
import xyz.fusheng.code.springboot.model.model.dto.ModelPageDto;
import xyz.fusheng.code.springboot.model.model.entity.Model;

import java.util.List;

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

    Model selectModelByModelName(@Param("modelName") String modelName);
    Page<Model> customPage(@Param("page") IPage<Model> page, @Param("pageDto") ModelPageDto pageDto);

    Model selectModelByIdOrModelName(Model model);

    Cursor<Model> selectModelsRegexpName(@Param("keyword") String keyword);

    void insertModel(Model model);

    List<Model> runCall(@Param("modelName") String modelName);

    List<Model> testMultiResults();
}
