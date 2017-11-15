package currentweather;

import httputility.HttpUtility;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CurrentWeatherReport {

    String currentWeatherReportUrlStart = "http://api.openweathermap.org/data/2.5/weather?q=";
    String apiCode = "ed2d0441550bad29e87a82b03e7ff532";


    public int currentWeatherReportTemperature(String city) throws Exception {
        JSONObject JSONObjectNow = new JSONObject(getWeatherString(city));
        JSONObject mainNow = (JSONObject) JSONObjectNow.get("main");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("weather.txt", true))) {
            String content = "\nCurrent weather report, temperature: " + objectToCelsius(mainNow.get("temp")) + "°C\n";
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectToCelsius(mainNow.get("temp"));
    }

    public static int objectToCelsius(Object o) {
        return (int) (Double.parseDouble(o.toString()) - 273.15);
    }


    public String getWeatherString(String city) throws Exception {
        return HttpUtility.makeHttpGetRequest(currentWeatherReportUrlStart + city + "&appid=" + apiCode);
    }


    public double getMaximumTemperature() {
        return 0;
    }


    public double getMinimumTemperature() {
        return 0;
    }


    public double getPressure() {
        return 0;
    }

}
