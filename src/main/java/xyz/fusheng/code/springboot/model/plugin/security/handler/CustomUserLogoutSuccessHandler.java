package xyz.fusheng.code.springboot.model.plugin.security.handler;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.core.entity.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CustomUserLogoutSuccessHandler
 * @date 2022-12-04 14:15:24
 */

@Component
public class CustomUserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(new ResultVo<>("登出成功!")));
    }
}

