package jsonTest;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class jsonTest {

    //HttpURLConnection connection = null;
    public static void main(String[] args){
        try{
            String str = "";
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1/comments");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)  url.openConnection();

            //httpsURLConnection.setConnectTimeout(10000);
            //httpsURLConnection.setReadTimeout(10000);


            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();


            System.out.println(str);
            System.out.println("종료");



        }catch(Exception e){

        }
    }



    //HttpsURLConnection httpsURLConnection = (HttpsURLConnection)
    //OutputStream outputStream = null;



}
