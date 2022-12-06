package xyz.fusheng.code.springboot.model.learn.文件;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @FileName: FileTest
 * @Author: code-fusheng
 * @Date: 2022/9/26 14:10
 * @Version: 1.0
 * @Description: 文件测试
 */

public class FileTest {

    public static void testIcbcTranDataExtract() throws IOException {
        // 模拟测试数据地址
        String zipFile = "https://aliyun-oss-model.oss-cn-beijing.aliyuncs.com/gsb/Accdtl_010300254497017970454203_0158000109000000803.zip";
        String binFile = "https://aliyun-oss-model.oss-cn-beijing.aliyuncs.com/gsb/10000000000004097566_010300254497017970454203_0158000109000000803_001.bin";
        String chkFile = "https://aliyun-oss-model.oss-cn-beijing.aliyuncs.com/gsb/10000000000004097566_010300254497017970454203_0158000109000000803_ALL_CHE_2021-09-26.chk";

        //
        URL url = new URL(zipFile);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        Map<String, byte[]> unzip = unzip(inputStream);
        for (Map.Entry<String, byte[]> entry : unzip.entrySet()) {
            System.out.println(entry.getKey() + ": " + new String(entry.getValue()));
        }
    }

    private static Map<String, byte[]> unzip(InputStream inputStream) {
        Map<String, byte[]> res = new ConcurrentHashMap<>();
        ZipInputStream zi = new ZipInputStream(inputStream);
        ZipEntry ze;
        byte[] buf = new byte[1024];
        int len;
        try {
            while (null != (ze = zi.getNextEntry())) {
                String name = ze.getName();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while (-1 != (len = zi.read(buf))) {
                    bos.write(buf, 0, len);
                }
                res.put(name, bos.toByteArray());
                bos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        testIcbcTranDataExtract();
    }

}
