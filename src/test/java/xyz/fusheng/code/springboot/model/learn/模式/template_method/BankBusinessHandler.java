package xyz.fusheng.code.springboot.model.learn.模式.template_method;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BankBusinessHandler
 * @date 2022-12-23 12:54:53
 */

public class BankBusinessHandler extends AbstractBusinessHandler {

    private void execute(Consumer<BigDecimal> consumer) {
        getNumber();
        // 这里面consumer.accept就是具体的业务逻辑，可能是存钱、取钱、理财等。需要由其他方法调用execute的时候传入。
        consumer.accept(null);
        judge();
    }

    private void executeV2(Supplier<String> supplier, Consumer<BigDecimal> consumer) {
        String number = supplier.get();
        System.out.println(number);
        if (number.startsWith("vip")) {
            System.out.println("Assign To Vip Counter");
        } else if (number.startsWith("reservation")) {
            System.out.println("Assign To Exclusive Customer Manager");
        } else {
            System.out.println("Assign To Usual Manager");
        }
        consumer.accept(null);
        judge();
    }

    private void getNumber() {
        System.out.println("number-00" + RandomUtils.nextInt());
    }

    @Override
    public void handle() {

    }

    private void judge() {
        System.out.println("give a praised");
    }

    /**
     * 通过使用Java 8中的Comsumer，我们把模板方法改造了，改造之后不再需要抽象类、抽象方法，也不再需要为每一个业务都创建一个实现类了。我们可以把所有的业务逻辑内聚在同一个业务类中。这样非常方便这段代码的后期运维。
     */

    public void save(BigDecimal amount) {
        execute(a -> System.out.println("save " + amount));
    }

    public void saveVip(BigDecimal amount) {
        executeV2(() -> "number-00" + RandomUtils.nextInt(), a -> System.out.println("save " + amount));
    }

    public void draw(BigDecimal amount) {
        execute(a -> System.out.println("draw " + amount));
    }

    public void moneyManage(BigDecimal amount) {
        execute(a -> System.out.println("manage " + amount));
    }

}

