package xyz.fusheng.code.springboot.model.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

}

