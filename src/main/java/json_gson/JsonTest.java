package json_gson;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

    public static void main(String[] args) {
        //String을 이용한 jsonObject 생성
        String jsonString = "{'age':20, 'name':'jjy'}";

        try {
            JSONObject json = new JSONObject(jsonString);

            System.out.println(json); //{"age":20,"name":"jjy"}

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            JSONObject json = new JSONObject(jsonString);
            System.out.println(json.getInt("age"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String jsonString2 = "{age:20, name:'jjy', 'student2':{'age':21, 'name' : 'galid'}}";
        try {
            JSONObject json = new JSONObject(jsonString2);
            System.out.println(json.getJSONObject("student2"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
