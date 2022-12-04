package xyz.fusheng.code.springboot.model.plugin.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.core.entity.ResultVo;
import xyz.fusheng.code.springboot.core.enums.ResultEnum;
import xyz.fusheng.code.springboot.model.plugin.security.config.JwtConfig;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;
import xyz.fusheng.code.springboot.model.plugin.security.util.JwtUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 自定义登录成功处理器
 * @date 2022-12-04 13:57:00
 */

@Component
public class CustomUserLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 组装 JWT
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        if (!Objects.isNull(customUser)) {
            BeanUtils.copyProperties(authentication.getPrincipal(), customUser);
        }
        String token = JwtConfig.tokenPrefix + JwtUtils.createAccessToken(customUser);
        // 封装返回参数
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(new ResultVo<>("登录成功!", token)));
    }

}

