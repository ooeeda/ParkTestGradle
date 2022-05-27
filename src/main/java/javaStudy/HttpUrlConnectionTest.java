package javaStudy;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpUrlConnectionTest {
    public static void main(String[] args){
        HttpUrlConnectionTest httpTest = new HttpUrlConnectionTest();
        httpTest.HttpsURLConnectionPost("https://fakestoreapi.com/products/1");
        //httpTest.HttpsURLConnectionPost("https://fakestoreapi.com/products");

    }
    public void HttpURLConnectionGet(String strURL, String strParams) {
        try {
            URL url = new URL(strURL + "?" + strParams); //get 방식은 parameter를 URL에 묶어서 보낸다.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "ko-kr");
            conn.setRequestProperty("Access-Control-Allow-Origin", "*");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setConnectTimeout(10000); // 커넥션 timeout 10초
            conn.setReadTimeout(5000); //컨텐츠 조회시 timeout 5초

            Charset charset = Charset.forName("UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

        } catch (MalformedURLException e) {
            //URL
            e.printStackTrace();
        } catch (IOException e) {
            // HttpURLConnection
            e.printStackTrace();
        }

    }

    public void HttpURLConnectionPost(String strURL, String strParams) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            //con.setRequestProperty("Authorization", alpha);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "ko-kr");
            conn.setRequestProperty("Access-Control-Allow-Origin", "*");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setConnectTimeout(10000); // 커넥션 timeout 10초
            conn.setReadTimeout(5000); //컨텐츠 조회시 timeout 5초

            conn.setDoOutput(true); //항상 갱신된 내용 가져오도록 true로 설정
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(strParams); //파라미터 write
            wr.flush();
            wr.close();

            //int responseCode = conn.getResponseCode();

            Charset charset = Charset.forName("UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            System.out.println(response.toString());


        } catch (MalformedURLException e) {
            //URL
            e.printStackTrace();
        } catch (IOException e) {
            //HttpURLConnection
            e.printStackTrace();
        }

    }

    public void HttpsURLConnectionPost(String strURL, String strParams) {
        //HttpsURLConnection은 HttpURLConnection을 상속 받는다.
        //사용 방식은 동일하나 http url과 https url이 다른 부분이다.

        try {
            URL url = new URL(strURL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            //conn.setRequestProperty("Authorization", alpha);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "ko-kr");
            conn.setRequestProperty("Access-Control-Allow-Origin", "*");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setConnectTimeout(10000); // 커넥션 timeout 10초
            conn.setReadTimeout(50000); //컨텐츠 조회시 timeout 5초

            conn.setDoOutput(true); //항상 갱신된 내용 가져오도록 true로 설정
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(strParams); //파라미터 write
            wr.flush();
            wr.close(); //6761690 ,


            //int responseCode = conn.getResponseCode();

           Charset charset = Charset.forName("UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            System.out.println("response String : "+response.toString());


        } catch (MalformedURLException e) {
            //URL
            e.printStackTrace();
        } catch (IOException e) {
            //HttpsURLConnection
            e.printStackTrace();
        }

    }

    public void HttpsURLConnectionPost(String strURL) {
        //HttpsURLConnection은 HttpURLConnection을 상속 받는다.
        //사용 방식은 동일하나 http url과 https url이 다른 부분이다.

        try {
            URL url = new URL(strURL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            JSONObject responseJson = null;

            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Authorization", alpha);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "ko-kr");
            conn.setRequestProperty("Access-Control-Allow-Origin", "*");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.setRequestProperty("Content-Type", "multipart/fom-data");

            conn.setConnectTimeout(10000); // 커넥션 timeout 10초
            conn.setReadTimeout(50000); //컨텐츠 조회시 timeout 5초

            conn.setDoOutput(true); //항상 갱신된 내용 가져오도록 true로 설정

            JSONObject json = new JSONObject();

           int responseCode = conn.getResponseCode();
            if (responseCode == 400 || responseCode == 401 || responseCode == 500 ) {
                System.out.println(responseCode + " Error!");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                responseJson = new JSONObject(sb.toString());
                System.out.println(responseJson);
            }

        } catch (MalformedURLException e) {
            //URL
            e.printStackTrace();
        } catch (IOException e) {
            //HttpsURLConnection
            e.printStackTrace();
        }

    }
}
