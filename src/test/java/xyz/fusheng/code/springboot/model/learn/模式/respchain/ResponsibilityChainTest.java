package xyz.fusheng.code.springboot.model.learn.模式.respchain;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 责任链模式测试
 * @date 2022-12-12 14:48:35
 */

public class ResponsibilityChainTest {

    public static void main(String[] args) {

        RespHandler handlerChain = new Handler1();
        handlerChain.setNextHandler(new Handler2());

        handlerChain.triggerProcess(new Object());

    }

}

