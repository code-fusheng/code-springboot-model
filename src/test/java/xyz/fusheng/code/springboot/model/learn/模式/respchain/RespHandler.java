package xyz.fusheng.code.springboot.model.learn.模式.respchain;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc RespHandler
 * @date 2022-12-12 14:55:38
 */

public abstract class RespHandler {

    // 当前处理器的下一个处理器
    private RespHandler nextHandler;

    // 当前处理器的处理逻辑，交给子类实现
    public abstract void handle(Object performer);

    // 出发当前处理器
    public void triggerProcess(Object performer) {
        handle(performer);
        if (nextHandler != null) {
            nextHandler.triggerProcess(performer);
        }
    }

    // 设置当前处理器的下一个处理器
    public RespHandler setNextHandler(RespHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

}

