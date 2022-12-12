package xyz.fusheng.code.springboot.model.learn.模式.respchain;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Handler1
 * @date 2022-12-12 15:25:39
 */

public class Handler1 extends RespHandler{
    @Override
    public void handle(Object performer) {
        System.out.println("handle ==> class:" + performer.getClass());
    }
}

