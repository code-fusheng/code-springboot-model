package xyz.fusheng.code.springboot.model.learn.类型.String;

import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @FileName: RegexpTest
 * @Author: code-fusheng
 * @Date: 2022/11/3 14:43
 * @Version: 1.0
 * @Description:
 */

public class RegexpTest {

    public static void main(String[] args) {
        testPattern();
        //test();

        String str = "年月日";
        System.out.println(cnToUnicode(str));
    }


    public static void testPattern() {
        String template = "我北京经开区时间企业可在2022年10月31日-12月6日参与申报";
        String regexp1 = "(\\d{4}\\u5e74\\d{2}\\u6708.*?\\u65e5|\\d{2}\\u6708.*?\\u65e5)";
        Pattern pattern = Pattern.compile(regexp1, Pattern.CANON_EQ);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String key = matcher.group();
            System.out.println(key);
        }
    }

    public static void test() {
        JSONObject paramsJson = new JSONObject();
        String tem = "您好，您的${type}案件(${name}), 第${ncl}类已收到申请通知书，申请号为${regNo}等待官方受理，您可以在商标工作台案件管理中查看案件进度。";
        JSONObject finalParams = new JSONObject();
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("\\$\\{.*?\\}");
        Matcher matcher = pattern.matcher(tem);
        while (matcher.find()) {
            String key = matcher.group().substring(2, matcher.group().length() - 1);
            matcher.appendReplacement(sb, String.valueOf(paramsJson.get(key)));
            finalParams.put(key, String.valueOf(paramsJson.get(key)));
        }
        matcher.appendTail(sb);
        String finalContent = sb.toString();
        paramsJson = finalParams;
        System.out.println(paramsJson);
    }

    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }

}
