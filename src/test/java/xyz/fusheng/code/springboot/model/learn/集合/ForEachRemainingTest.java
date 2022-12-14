package xyz.fusheng.code.springboot.model.learn.ιε;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @FileName: CollectionTest
 * @Author: code-fusheng
 * @Date: 2021/6/21 4:24 δΈε
 * @Version: 1.0
 * @Description:
 */

public class ForEachRemainingTest {

    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add("World");

        Iterator<String> iterator = collection.iterator();

        iterator.forEachRemaining(System.out::println);

    }

}
