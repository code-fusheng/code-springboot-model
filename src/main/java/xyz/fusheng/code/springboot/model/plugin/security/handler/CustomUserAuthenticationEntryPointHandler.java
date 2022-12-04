package xyz.fusheng.code.springboot.model.plugin.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.core.entity.ResultVo;
import xyz.fusheng.code.springboot.core.enums.ResultEnum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CustomUserAuthenticationEntryPointHandler
 * @date 2022-12-04 14:14:02
 */

@Component
public class CustomUserAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(new ResultVo<>(ResultEnum.NOT_LOGIN)));
    }
}

