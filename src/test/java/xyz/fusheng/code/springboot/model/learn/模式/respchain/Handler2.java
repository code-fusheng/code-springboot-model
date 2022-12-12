package xyz.fusheng.code.springboot.model.learn.模式.respchain;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Handler2
 * @date 2022-12-12 15:27:11
 */

public class Handler2 extends RespHandler {
    @Override
    public void handle(Object performer) {
        System.out.println("handle ==> className:" + performer.getClass().getName());
    }
}

