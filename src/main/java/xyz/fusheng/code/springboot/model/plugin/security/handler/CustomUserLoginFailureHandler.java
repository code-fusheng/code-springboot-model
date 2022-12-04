package xyz.fusheng.code.springboot.model.plugin.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.core.entity.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CustomUserLoginFailureHandler
 * @date 2022-12-04 14:14:42
 */

@Component
public class CustomUserLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (e instanceof UsernameNotFoundException) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(new ResultVo<>(500, "登录失败: 用户名不存在！")));
        }
        if (e instanceof LockedException) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(new ResultVo<>(500, "登录失败: 用户被冻结！")));
        }
        if (e instanceof BadCredentialsException) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(new ResultVo<>(500, "登录失败: 用户名密码不正确！")));
        }
        // TODO 待完善
    }
}

