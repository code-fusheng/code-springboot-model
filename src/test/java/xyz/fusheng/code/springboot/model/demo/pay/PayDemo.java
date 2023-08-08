package xyz.fusheng.code.springboot.model.demo.pay;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc PayDemo
 * @date 2022-12-21 20:42:04
 */

@SpringBootTest
// @RunWith(SpringRunner.class)
public class PayDemo {

    @Resource
    private PayFactory payFactory;

    public void dealPay(String code) {
        PayHandler payHandler = payFactory.getHandlerByCode(code);
        payHandler.dealPay();
    }

    // @Test
    public void testPay() {
        dealPay(PayChannelEnum.WECHAT_PAY.getCode());
    }

}

