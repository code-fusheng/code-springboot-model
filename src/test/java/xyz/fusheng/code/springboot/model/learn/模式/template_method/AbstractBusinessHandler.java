package xyz.fusheng.code.springboot.model.learn.模式.template_method;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 模版方法设计模式抽象类
 * @date 2022-12-23 12:27:12
 */

public abstract class AbstractBusinessHandler {

    /**
     * 模版方法
     */
    public final void execute() {
        getNumber();
        handle();
        judge();
    }

    /**
     * 取号
     */
    private void getNumber() {
        System.out.println("number-00" + RandomUtils.nextInt());
    }

    /**
     * 办理业务
     */
    public abstract void handle();

    /**
     * 评价
     */
    private void judge() {
        System.out.println("give a praised");
    }

}

