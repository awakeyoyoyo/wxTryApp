package com.awakeyoyoyo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtils {
//
//    public static void main(String[] args) {
//        //发送 GET 请求
//        String s=HttpUtils.SendGet("http://baidu.com", "");
//        System.out.println(s);
//
//    }

    public static String SendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        String urlNameString = url + "?" + param;
        try {
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
