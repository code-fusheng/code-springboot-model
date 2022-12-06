package xyz.fusheng.code.springboot.model.plugin.security.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import xyz.fusheng.code.springboot.model.plugin.security.config.JwtConfig;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;

import java.util.Date;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc JwtUtils
 * @date 2022-12-04 13:59:04
 */

public class JwtUtils {

    public static String createAccessToken(CustomUser customUser){
        String token = Jwts.builder()
                // 放入用户名和用户id
                .setId(String.valueOf(customUser.getId()))
                // 主题
                .setSubject(customUser.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("zh")
                // 自定义属性，放入用户拥有的权限
                .claim("authorities", JSON.toJSONString(customUser.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JwtConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JwtConfig.secret)
                .compact();
        return token;
    }

}

