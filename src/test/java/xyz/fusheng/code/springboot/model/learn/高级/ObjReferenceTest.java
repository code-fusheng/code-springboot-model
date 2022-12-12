package xyz.fusheng.code.springboot.model.learn.高级;

import xyz.fusheng.code.springboot.model.model.entity.Model;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 对象引用级别测试
 * @date 2022-12-10 16:35:23
 *
 * · 强引用（SoftReference）：即我们平时所说的引用。只要一个对象能够被 GC Root强引用到，那它就不是垃圾对象。当内存不足时，JVM 会抛出 OutOfMemoryError错误而不是清除被强引用的对象。
 * · 软引用（SoftReference）：如果一个对象只能被 GC Root软引用到，则说明它是非必需的。当内存空间不足时，JVM会回收该对象。
 * · 弱引用（WeakReference）：如果一个对象只能被 GC Root弱引用到，则说明它是多余的。JVM只要发现它，不管内存空间是否充足都会回收该对象。与软引用相比，弱引用的引用强度更低，被弱引用的对象存在时间相对更短。
 * · 虚引用（PhantomReference）：如果一个对象只能被 GC Root虚引用到，则和无法被GC Root引用到时一样。因此，就垃圾回收过程而言，虚引用就像不存在一样，并不会决定对象的生命周期。虚引用主要用来跟踪对象被垃圾回收器回收的活动。
 *
 */

public class ObjReferenceTest {

    public static void main(String[] args) {

        // 强引用
        Model model = new Model();

        // 软引用
        SoftReference<Model> softReference = new SoftReference<>(new Model());

        // 弱引用
        WeakReference<Model> weakReference = new WeakReference<>(new Model());


    }

}

