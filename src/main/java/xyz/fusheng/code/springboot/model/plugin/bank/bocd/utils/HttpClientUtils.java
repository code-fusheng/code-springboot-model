package xyz.fusheng.code.springboot.model.plugin.bank.bocd.utils;

import com.google.gson.Gson;
import com.ruim.ifsp.utils.message.IfspBase64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 
 * 名称：〈HTTP测试类〉<br> 
 * 功能：〈功能详细描述〉<br>
 * 版本：1.0 <br>
 * 日期：2016年4月30日 <br>
 * 作者：yema <br>
 * 说明：<br>
 */
public class HttpClientUtils {
    
    public static String send(Object reqBean, String txnCode,  String urlstr, boolean base64Flag){
        
        //报文转换
        String message = "";
        Gson gson = new Gson();
        message = gson.toJson(reqBean);
        
        //Base64转码
        if(base64Flag){
            message = IfspBase64.encode(message);
        }
        
        //组装完整请求地址
        urlstr = urlstr + txnCode;
        try {

            for (int i = 0; i < 1; ) {
            	Thread.sleep(1000);
                URL url = new URL(urlstr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestProperty("Content-type", "application/json");
                connection.connect();
                
                PrintWriter conOut = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
                conOut.write(message);
                conOut.flush();
                conOut.close();

//                System.out.println(connection.getResponseCode());
//                System.out.println(connection.getContentLength());
                @SuppressWarnings("unused")
                Map<String, List<String>> map = connection.getHeaderFields();
//                for (Entry<String, List<String>> entry : map.entrySet()) {
//                    System.out.println("key=" + entry.getKey());
//                    for (String string : entry.getValue()) {
//                        System.out.println("------" + string);
//                    }
//                }
                String result = changeInputStreamToString(connection.getInputStream(), "UTF-8");
                System.out.println(result);
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ""; 
    }


	private static String changeInputStreamToString(InputStream is, String charsetName)
			throws UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is, charsetName));

		StringBuffer sb = new StringBuffer();
		String str = null;

		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		br.close();

		return sb.toString();
	}
}
