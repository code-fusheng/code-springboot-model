package xyz.fusheng.code.springboot.model.demo.pay;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 支付工厂
 * @date 2022-12-21 20:33:53
 */

@Component
public class PayFactory implements InitializingBean {

    // 对于@Autowired声明的数组、集合类型，spring并不是根据beanName去找容器中对应的bean，而是把容器中所有类型与集合（数组）中元素类型相同的bean构造出一个对应集合，注入到目标bean中
    @Resource
    private List<PayHandler> payHandlerList = new ArrayList<>();

    private Map<PayChannelEnum, PayHandler> handlerMap = new HashMap<>();

    public PayHandler getHandlerByCode(String code) {
        PayChannelEnum payChannelEnum = PayChannelEnum.of(code);
        return handlerMap.get(payChannelEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (PayHandler payHandler : payHandlerList) {
            handlerMap.put(payHandler.getChannel(), payHandler);
        }
    }

}

