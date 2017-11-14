package currentweather;

import httputility.HttpUtility;
import org.json.JSONObject;

public class CurrentWeatherReport {

    String currentWeatherReportUrl = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn&appid=ed2d0441550bad29e87a82b03e7ff532";


    public int currentWeatherReport() throws Exception {
        JSONObject JSONObjectNow = new JSONObject(getWeatherString());
        JSONObject mainNow = (JSONObject) JSONObjectNow.get("main");
        return objectToCelsius(mainNow.get("temp"));
    }


    public static int objectToCelsius(Object o) {
        return (int) (Double.parseDouble(o.toString()) - 273.15);
    }


    public String getWeatherString() throws Exception {
        return HttpUtility.makeHttpGetRequest(currentWeatherReportUrl);
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
