package forecast;

import org.json.JSONException;
import org.json.JSONObject;

public class Jsonwriter {


    public static void main(String[] args) throws JSONException {
        try {
            writeJson();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void writeJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("Name", "crunchify.com");
        obj.put("Author", "App Shah");
        String author = obj.getString("Author");
        System.out.println(obj.getString("Author"));
    }


}
