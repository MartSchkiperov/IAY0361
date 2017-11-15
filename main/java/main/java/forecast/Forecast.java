package forecast;

import httputility.HttpUtility;
import org.json.JSONArray;
import org.json.JSONObject;

public class Forecast {

    String forecastUrl = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn&appid=ed2d0441550bad29e87a82b03e7ff532";


    public void forecast() throws Exception {
        JSONObject JSONWeatherObject = new JSONObject(getWeatherString());
        JSONArray JSONArrayList = (JSONArray) JSONWeatherObject.get("list");
        for (int i = 0; i < JSONArrayList.length(); i++) {
            JSONObject threeHourData = (JSONObject) JSONArrayList.get(i);
            JSONObject threeHourMain = threeHourData.getJSONObject("main");
            System.out.println(threeHourData.get("dt_txt") + " " + objectToCelsius(threeHourMain.get("temp_min"))
                    + " " + objectToCelsius(threeHourMain.get("temp_max")));
        }
    }


    public static int objectToCelsius(Object o) {
        return (int) (Double.parseDouble(o.toString()) - 273.15);
    }


    public String getWeatherString() throws Exception {
        return HttpUtility.makeHttpGetRequest(forecastUrl);
    }

}
