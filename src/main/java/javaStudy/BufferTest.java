package javaStudy;



import java.io.*;
import java.util.StringTokenizer;

public class BufferTest {
    public static void main(String[] args)  {
        BufferTest bufferTest = new BufferTest();

        bufferTest.BufferReadTest();

    }

    public void BufferReadTest() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            //int i = Integer.parseInt(bufferedReader.readLine());ㅎ

            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());

            String array[] = s.split(" ");


            //System.out.println(s);
            for(String str : array){
                System.out.println("system out :"+str);
            }
            //System.out.println(i);
            bufferedReader.close();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(String str : array){
                bw.write("bufferedWriter "+str+"\n");
            }
             //버퍼에 있는 값 전부 출력
            bw.flush();   //남아있는 데이터를 모두 출력시킴
            bw.close();   //스트림을 닫음
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}



