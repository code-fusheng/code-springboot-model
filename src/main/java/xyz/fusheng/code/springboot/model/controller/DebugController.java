package xyz.fusheng.code.springboot.model.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.code.springboot.core.annotaion.NoBodyAdvice;
import xyz.fusheng.code.springboot.core.entity.ResultVo;
import xyz.fusheng.code.springboot.model.plugin.bank.bocd.dto.BocdBackendNotifyDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 调试模块
 * @date 2023-03-27 15:49:47
 */

@RestController
@RequestMapping("/debug")
@Api(tags = "调试模块")
@Slf4j
public class DebugController {

    @PostMapping("/api/no_auth/camera/heartbeat")
    public void heartbeat(@RequestParam String device_name,
                          @RequestParam String ipaddr,
                          @RequestParam String port,
                          @RequestParam String user_name,
                          HttpServletRequest request) {
        log.info("==> 心跳调试");
    }

    @PostMapping("/api/no_auth/camera/local_process_zhenshi")
    public void licencePush(@RequestBody JSONObject json, HttpServletRequest request) throws UnsupportedEncodingException {
        // String str = new String(Objects.requireNonNull(requestEntity.getBody()), StandardCharsets.UTF_8);
        // log.info("==> 调试 str:{}", str);
        log.info("==> 调试 json:{}", json);
        // String decodeStr = URLDecoder.decode(str, "UTF-8");
        // log.info("==> 调试 decodeStr:{}", decodeStr);
    }

    @PostMapping("/pay/bocd/asyncNotify")
    public String asyncNotify(HttpServletRequest request, HttpServletResponse response, BocdBackendNotifyDto bocdBackendNotifyDto) {
        Map<String, String[]> map = request.getParameterMap();
        log.info("map:{}", map);
        log.info("bocdBackendNotifyDto:{}", JSON.toJSONString(bocdBackendNotifyDto));
        response.setStatus(200);
        return "SUCCESS";
    }

    private <T> T mapToObject(Map map, Class<T> target) {
        Field[] fields = target.getDeclaredFields();
        try {
            T o = target.newInstance();
            for (Field field: fields) {
                String[] values = (String[]) map.get(field.getName());
                if (values.length != 0 && values[0] != null) {
                    field.setAccessible(true);
                    field.set(o, values[0]);
                }
            }
            return o;
        } catch (Exception e) {
            log.error("对象转换异常 e:{}", e.getMessage(), e);
        }
        return null;
    }

}

