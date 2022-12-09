package xyz.fusheng.code.springboot.model.learn.算法.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BloomFilterTest
 * @date 2022-12-09 09:57:06
 *
 * 布隆过滤器测试
 *
 * 应用场景
 *
 */

public class BloomFilterTest {

    private static final Integer CAPACITY = 1000000;

    private static final double FALSE_POSITIVE_RATE = 0.01;

    public static void testGuavaBloomFilter() {

        int rightCount = 0;
        int errorCount = 0;

        // 创建一个布隆过滤器，容量为 CAPACITY，误判率为 FALSE_POSITIVE_RATE
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), CAPACITY, FALSE_POSITIVE_RATE);

        // Real Set
        HashSet<String> sets = new HashSet<>(CAPACITY);

        // Real List
        List<String> lists = new ArrayList<String>(CAPACITY);

        for (int i = 0; i < CAPACITY; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }

        for (int i = 0; i < 10000; i++) {
            String data = i % 100 == 0 ? lists.get(i / 100) : UUID.randomUUID().toString();
            if (bloomFilter.mightContain(data)) {
                if (sets.contains(data)) {
                    rightCount ++;
                    continue;
                }
                errorCount ++;
            }
        }

        BigDecimal percent = new BigDecimal(errorCount).divide(new BigDecimal(9900), 2, RoundingMode.HALF_UP);
        BigDecimal bingo = new BigDecimal(9900 - errorCount).divide(new BigDecimal(9900), 2, RoundingMode.HALF_UP);

        System.out.println("在100W个元素中，判断100个实际存在的元素，布隆过滤器认为存在的：" + rightCount);
        System.out.println("在100W个元素中，判断9900个实际不存在的元素，误认为存在的：" + errorCount + "，命中率：" + bingo + "，误判率：" + percent);

    }

    public static void main(String[] args) {
        testGuavaBloomFilter();
    }

}

