package xyz.fusheng.code.springboot.model.learn.模式.template_method;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 取钱业务 处理器
 * @date 2022-12-23 12:38:20
 */

public class DrawMoneyHandler extends AbstractBusinessHandler {

    @Override
    public void handle() {
        System.out.println("draw money 1000");
    }

}

