package xyz.fusheng.code.springboot.model.test;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc SwitchTest
 * @date 2023-08-09 1:23 PM:07
 */

public class SwitchTest {

    public static void main(String[] args) {


        int x = 10;
        switch (x) {
            case 9:
                x+=1;
                break;
            case 10:
                x+=1;
                break;
            case 11:
                x+=1;
                break;
            default:
                x+=1;
                break;
        }
        System.out.println(x);
    }

}

