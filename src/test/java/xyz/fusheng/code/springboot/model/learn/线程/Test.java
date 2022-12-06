package xyz.fusheng.code.springboot.model.learn.线程;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @FileName: Test
 * @Author: code-fusheng
 * @Date: 2022/8/25 20:28
 * @Version: 1.0
 * @Description:
 */

public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {
        List<String> urlList = initUrlData();
        CompletableFuture[] threadArray = urlList.stream().map(it -> testDownload(it)).toArray(CompletableFuture[]::new);
        ;
        CompletableFuture.allOf(threadArray).join();
    }

    private static List<String> initUrlData() {

        List<String> urlList = new ArrayList<>();
        urlList.add("https://nga-offline.oss-cn-beijing-internal.aliyuncs.com/download/2022-08-25/575_505293/归档流程测试202207归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202201归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202202归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202203归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202204归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202205归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202206归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司_202207归档.zip");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/总账-2022年期-北京格汇知识产权服务有限公司.pdf");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司明细账2022.pdf");
        //urlList.add("https://nga-offline.oss-cn-beijing.aliyuncs.com/download/2022-08-22/111_508870/北京格汇知识产权服务有限公司科目余额表2022.pdf");
        return urlList;

    }

    private static Object testDownload(String url) {
        try {
            getInputStream(url);
            logger.info(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream getInputStream(String urlPath) {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlPath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置网络连接超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 设置应用程序要从网络连接读取数据
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("responseCode is:" + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 从服务器返回一个输入流
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    private static Map<String, byte[]> unzip(InputStream inputStream) {
        Map<String, byte[]> res = new ConcurrentHashMap<>();
        ZipInputStream zi = new ZipInputStream(inputStream);
        ZipEntry z;
        byte[] buf = new byte[1024];
        int len;
        try {
            while (null != (z = zi.getNextEntry())) {
                String name = String.format("%d%02d" + "/" + z.getName());

                ByteArrayOutputStream fos = new ByteArrayOutputStream();
                while (-1 != (len = zi.read(buf))) {
                    fos.write(buf, 0, len);
                }
                res.put(name, fos.toByteArray());
                fos.close();
            }
            zi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
