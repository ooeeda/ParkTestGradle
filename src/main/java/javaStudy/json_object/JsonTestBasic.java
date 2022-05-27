package javaStudy.json_object;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonTestBasic {

    public static void main(String[] args){
        String json = "{item : [{id:\"1\", name: \"이름1\"},{id :\"2\",name : \"이름2\"}] }";
        System.out.println(json);
        //참조방식 이해를 위한 예제
        try{
            JSONObject formatObj = new JSONObject(json);
            JSONObject newFormatObj = formatObj;

            JSONArray itemsList = newFormatObj.getJSONArray("item");

            for(int i=0; i<itemsList.length();i++){
                JSONObject itemsObj = itemsList.getJSONObject(i);
                if(i==1){
                    itemsObj.remove("id");
                    itemsList.remove(i);
                }
                System.out.println(itemsObj.toString());
            }

            String formatJson = formatObj.toString();
            System.out.println(formatJson);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


