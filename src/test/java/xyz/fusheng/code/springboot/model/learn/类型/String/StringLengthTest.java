package xyz.fusheng.code.springboot.model.learn.类型.String;

import xyz.fusheng.code.springboot.core.util.StringUtils;

/**
 * @FileName: StringTest
 * @Author: code-fusheng
 * @Date: 2022/6/13 14:28
 * @Version: 1.0
 * @Description:
 */

public class StringLengthTest {

    private static void testMatch() {
        String str1 = "RZ10000001";
        String str2 = "Temp-0-RZ10000001";
        String str3 = "1111";
        System.out.println(str1.indexOf("RZ"));
        System.out.println(str2.indexOf("RZ"));
        System.out.println(str3.indexOf("RZ"));

    }

    private static void testLength() {
        // 93
        String str1 = "结转05月民生银行1981汇兑损益（05月31日美元剩余58972.48汇率6.6607） (USD: 895.46 汇率: 6.6607)";
        String str2 = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七";
        String str3 = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五";
        String str4 = "1234567890123456789012345678901234567890123456789012345678901234567";
        // 85
        String str5 = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345";
        // ..........
        // 1111111111
        // 9999999999
        // ））））））））））
        // ))))))))))
        // 哈哈哈哈哈哈哈哈哈哈
        Long length = StringUtils.calculateStandardLength(str1);
        System.out.println(length);
    }

    public static void main(String[] args) {

        //testMatch();
        testLength();

    }

    /**
     * 是中文汉字
     *
     * @param c
     * @return
     */
    private static boolean isChineseCharacter(char c) {
        // 获取字符 UniCodeBlock
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
            return true;
        }
        return false;
    }

    /**
     * 是中文符号
     *
     * @param c
     * @return
     */
    private static boolean isChineseSymbol(char c) {
        //
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 是数字
     *
     * @param c
     * @return
     */
    private static boolean isNumber(char c) {
        if (Character.isDigit(c)) {
            return true;
        }
        return false;
    }

    /**
     * 是英文字符
     *
     * @param c
     * @return
     */
    private static boolean isEnglishSymbol(char c) {
        int ascii_c = c;
        if (ascii_c >= 65 && ascii_c <= 90) {
            // 大写英文字母
            return true;
        }
        if (ascii_c >= 97 && ascii_c <= 122) {
            // 小写英文字母
            return true;
        }
        if (ascii_c >= 33 && ascii_c <= 126) {
            // 英文字符
            return true;
        }
        if ((ascii_c >= 27 && ascii_c <= 254)) {
            // 符号
            return true;
        }
        return false;
    }

}
