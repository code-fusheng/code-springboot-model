package xyz.fusheng.code.springboot.model.plugin.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.core.entity.ResultVo;
import xyz.fusheng.code.springboot.core.enums.ResultEnum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CustomUserAuthAccessDeniedHandler
 * @date 2022-12-04 14:13:13
 */

@Component
public class CustomUserAuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(new ResultVo<>(ResultEnum.NOT_AUTHORIZED)));
    }
}

