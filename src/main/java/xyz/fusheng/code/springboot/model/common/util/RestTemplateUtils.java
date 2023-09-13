package xyz.fusheng.code.springboot.model.common.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author code-fusheng
 */

@Slf4j
public class RestTemplateUtils {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate() {{
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        // 请求超时时间 60s
        requestFactory.setConnectTimeout(60 * 1000);
        // 读取超时时间 60s
        requestFactory.setReadTimeout(60 * 1000);
        setRequestFactory(requestFactory);
        setUriTemplateHandler(new DefaultUriBuilderFactory());
        List<HttpMessageConverter<?>> httpMessageConverters = getMessageConverters();
        httpMessageConverters.stream().forEach(httpMessageConverter -> {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                StringHttpMessageConverter messageConverter = (StringHttpMessageConverter) httpMessageConverter;
                messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
            }
        });
        httpMessageConverters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        httpMessageConverters.add(new FastJsonHttpMessageConverter() {{
            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
            // 解决Long转json精度丢失的问题
            SerializeConfig serializeConfig = SerializeConfig.globalInstance;
            serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
            serializeConfig.put(BigDecimal.class, ToStringSerializer.instance);
            serializeConfig.put(Long.class, ToStringSerializer.instance);
            serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
            fastJsonConfig.setSerializeConfig(serializeConfig);
            fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
            setFastJsonConfig(fastJsonConfig);
        }});
    }};

    private static <T> T exchange(RequestEntity<?> requestEntity, Class<T> responseType) {
        UUID uuid = UUID.randomUUID();
        log.info("请求开始,请求id: {}, uri: {}, method: {}, headers: {}, body: {}", uuid, requestEntity.getUrl(), requestEntity.getMethod(), requestEntity.getHeaders(), requestEntity.getBody());
        ResponseEntity<T> exchange = null;
        String responseBody = null;
        HttpStatus httpStatus = null;
        try {
            exchange = REST_TEMPLATE.exchange(requestEntity, responseType);
        } catch (RestClientException e) {
            log.error("请求异常,请求id: {}", uuid, e);
            if (e instanceof HttpStatusCodeException) {
                httpStatus = ((HttpStatusCodeException) e).getStatusCode();
                responseBody = ((HttpStatusCodeException) e).getResponseBodyAsString();
            } else {
                throw e;
            }
        }
        T response = null;
        if (exchange != null) {
            httpStatus = exchange.getStatusCode();
            response = exchange.getBody();
        } else {
            try {
                response = JSONObject.parseObject(responseBody, responseType);
            } catch (JSONException e) {
                response = responseType.cast(responseBody);
            }
        }
        log.info("请求结束,请求id: {},httpStatus: {}, response: {}", uuid, httpStatus, response);
        return response;
    }

    /**
     * 获取RestTemplate实例对象，可自由调用其方法
     *
     * @return RestTemplate实例对象
     */
    public static RestTemplate getRestTemplate() {
        return REST_TEMPLATE;
    }

    public static <T> T exchange(String url, HttpMethod method, Map<String, String> headers, Map<String, Object> queryParams, Object body, Class<T> responseType) {
        return exchange(url, method, headers, queryParams, body, responseType, new HashMap<>());
    }

    public static <T> T exchange(String url, HttpMethod method, Map<String, String> headers, Map<String, Object> queryParams, Object body, Class<T> responseType, Map<String, ?> uriVariables) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (null == headers) {
            headers = new HashMap<>();
        }
        headers.putIfAbsent("Accept", "*/*");
        headers.putIfAbsent("Content-Type", "application/json;charset=UTF-8");
        httpHeaders.setAll(headers);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (null != queryParams) {
            Map<String, String> tmpMap = new HashMap<>();
            if (!queryParams.isEmpty()) {
                queryParams.forEach((k, v) -> {
                    if (v != null) {
                        tmpMap.put(k, v.toString());
                    }
                });
            }
            params.setAll(tmpMap);
        }
        if (null == uriVariables) {
            uriVariables = new HashMap<>();
        }
        if (MediaType.APPLICATION_FORM_URLENCODED.includes(httpHeaders.getContentType())) {
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            if (null != body) {
                Map<String, Object> jsonObject;
                if (body instanceof Map) {
                    jsonObject = (Map<String, Object>) body;
                } else if (body instanceof String) {
                    jsonObject = JSONObject.parseObject((String) body);
                } else {
                    jsonObject = JSONObject.parseObject(JSONObject.toJSONString(body));
                }
                map.setAll(jsonObject);
            }
            body = map;
        }
        URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(params).build(uriVariables);
        RequestEntity<?> requestEntity = new RequestEntity<>(body, httpHeaders, method, uri);
        return exchange(requestEntity, responseType);
    }

    public static <T> T get(String url, Class<T> clz) {
        return get(url, null, null, clz);
    }

    public static <T> T get(String url, Map<String, Object> params, Class<T> clz) {
        return get(url, null, params, clz);
    }

    public static <T> T get(String url, Map<String, String> headers, Map<String, Object> params, Class<T> clz) {
        return exchange(url, HttpMethod.GET, headers, params, null, clz);
    }

    public static String getString(String url) {
        return getString(url, null, null);
    }

    public static String getString(String url, Map<String, Object> params) {
        return getString(url, null, params);
    }

    public static String getString(String url, Map<String, String> headers, Map<String, Object> params) {
        return exchange(url, HttpMethod.GET, headers, params, null, String.class);
    }

    public static JSONObject getJSONObject(String url) {
        return getJSONObject(url, null, null);
    }

    public static JSONObject getJSONObject(String url, Map<String, Object> params) {
        return getJSONObject(url, null, params);
    }

    public static JSONObject getJSONObject(String url, Map<String, String> headers, Map<String, Object> params) {
        return exchange(url, HttpMethod.GET, headers, params, null, JSONObject.class);
    }

    public static Resource getResource(String url) {
        return getResource(url, null, null);
    }

    public static Resource getResource(String url, Map<String, Object> params) {
        return getResource(url, null, params);
    }

    public static Resource getResource(String url, Map<String, String> headers, Map<String, Object> params) {
        return exchange(url, HttpMethod.GET, headers, params, null, Resource.class);
    }

    public static <T> T post(String url, Class<T> clz) {
        return post(url, null, null, clz);
    }

    public static <T> T post(String url, Object body, Class<T> clz) {
        return post(url, null, body, clz);
    }

    public static <T> T post(String url, Map<String, String> headers, Object body, Class<T> clz) {
        return exchange(url, HttpMethod.POST, headers, null, body, clz);
    }

    public static String postString(String url) {
        return postString(url, null, null);
    }

    public static String postString(String url, Object body) {
        return postString(url, null, body);
    }

    public static String postString(String url, Map<String, String> headers, Object body) {
        return exchange(url, HttpMethod.POST, headers, null, body, String.class);
    }

    public static JSONObject postJSONObject(String url) {
        return postJSONObject(url, null, null);
    }

    public static JSONObject postJSONObject(String url, Object body) {
        return postJSONObject(url, null, body);
    }

    public static JSONObject postJSONObject(String url, Map<String, String> headers, Object body) {
        return exchange(url, HttpMethod.POST, headers, null, body, JSONObject.class);
    }

    public static Resource postResource(String url) {
        return postResource(url, null, null);
    }

    public static Resource postResource(String url, Object body) {
        return postResource(url, null, body);
    }

    public static Resource postResource(String url, Map<String, String> headers, Object body) {
        return exchange(url, HttpMethod.POST, headers, null, body, Resource.class);
    }
}
