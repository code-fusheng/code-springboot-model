package xyz.fusheng.code.springboot.model.core.service.impl;

import xyz.fusheng.code.springboot.model.model.entity.Model;
import xyz.fusheng.code.springboot.model.core.mapper.ModelMapper;
import xyz.fusheng.code.springboot.model.core.service.IModelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-11-29
 */
@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements IModelService {

}
