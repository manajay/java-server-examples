package com.lj.spring.util;

/**
 * @Author 段连洁 [ manajay.dlj@gmail.com ]
 * @Date 04/08/2017 2:09 PM
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class HttpSenderTest
 * @description test  pb
 * @date 04/08/2017 2:09 PM
 */
public class HttpSenderTest {


    public static String executePost(String targetURL, byte[] content, boolean gzip, boolean json) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            if (json) {
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            }
            else {
                connection.setRequestProperty("Content-Type", "application/x-protobuf;charset=UTF-8");
            }

            //if (gzip) connection.setRequestProperty("Content-Encoding", "gzip");

            connection.setRequestProperty("Content-Length", Integer.toString(content.length));

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            OutputStream wr = connection.getOutputStream();
            wr.write(content);
            wr.flush();
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(connection.getResponseCode());
            System.out.println(response);
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
