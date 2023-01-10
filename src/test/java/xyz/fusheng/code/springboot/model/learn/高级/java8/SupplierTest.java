package xyz.fusheng.code.springboot.model.learn.高级.java8;

import cn.hutool.core.lang.copier.Copier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc java8 Supplier 供给型接口
 * @date 2022-12-23 12:45:16
 */

public class SupplierTest {

    public List<String> getList() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // getList() <==> Supplier
        Supplier<List<String>> listSupplier = ArrayList::new;
    }

}

