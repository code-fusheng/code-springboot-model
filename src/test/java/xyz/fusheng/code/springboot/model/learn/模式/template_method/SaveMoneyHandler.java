package xyz.fusheng.code.springboot.model.learn.模式.template_method;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 存钱业务 处理器
 * @date 2022-12-23 12:33:08
 */

public class SaveMoneyHandler extends AbstractBusinessHandler {

    @Override
    public void handle() {
        System.out.println("save money 1000");
    }

}

