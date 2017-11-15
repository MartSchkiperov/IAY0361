package forecast;

import httputility.HttpUtility;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Forecast {

    String forecastUrlStart = "http://api.openweathermap.org/data/2.5/forecast?q=";
    String apiCode = "ed2d0441550bad29e87a82b03e7ff532";

    public void forecast(String city) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("weather.txt", true))) {
            String content = "\nCurrent forecast for 5 days, min-max temperature in °C" + "\n";
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject JSONWeatherObject = new JSONObject(getWeatherString(city));
        JSONArray JSONArrayList = (JSONArray) JSONWeatherObject.get("list");
        for (int i = 0; i < JSONArrayList.length(); i++) {
            JSONObject threeHourData = (JSONObject) JSONArrayList.get(i);
            JSONObject threeHourMain = threeHourData.getJSONObject("main");
            System.out.println(threeHourData.get("dt_txt") + " " + objectToCelsius(threeHourMain.get("temp_min"))
                    + " " + objectToCelsius(threeHourMain.get("temp_max")));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("weather.txt", true))) {
                String content = threeHourData.get("dt_txt") + " " + objectToCelsius(threeHourMain.get("temp_min"))
                        + " " + objectToCelsius(threeHourMain.get("temp_max")) + "\n";
                bw.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static int objectToCelsius(Object o) {
        return (int) (Double.parseDouble(o.toString()) - 273.15);
    }


    public String getWeatherString(String city) throws Exception {
        return HttpUtility.makeHttpGetRequest(forecastUrlStart + city + "&appid=" + apiCode);
    }

}
