package xyz.fusheng.code.springboot.model.learn.模式.template_method;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 理财业务 处理器
 * @date 2022-12-23 12:39:38
 */

public class MoneyManageHandler extends AbstractBusinessHandler {

    @Override
    public void handle() {
        System.out.println("money manage");
    }

}

