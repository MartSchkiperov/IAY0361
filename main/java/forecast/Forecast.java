package forecast;

import httputility.HttpUtility;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Forecast {

    public String forecastUrlStart = "http://api.openweathermap.org/data/2.5/forecast?q=";
    public String apiCode = "ed2d0441550bad29e87a82b03e7ff532";
    //http://api.openweathermap.org/data/2.5/forecast?q=tallinn&appid=ed2d0441550bad29e87a82b03e7ff532

    String city;
    ForecastData cityData;
    JSONObject JSONWeatherObject;
    int d1min;
    int d1max;
    int d2min;
    int d2max;
    int d3min;
    int d3max;


    public Forecast(String city, String purpose) throws Exception {
        this.city = city;
        this.cityData = new ForecastData(city);
        if (purpose.equals("internet")) {
            this.JSONWeatherObject = new JSONObject(getForecastString());
        }
        if (purpose.equals("disk")) {
            this.JSONWeatherObject = new JSONObject(getForecastFromDisk());
        }
        if (purpose.equals("testing")) {
            this.JSONWeatherObject = new JSONObject(getForecastForTesting());
        }
    }


    public void forecast() throws Exception {
        forecastJSONProcessing();
        forecastPrinting();
        forecastToConsole();
    }


    public void forecastJSONProcessing() throws Exception {
        JSONArray JSONArrayList = (JSONArray) JSONWeatherObject.get("list");
        JSONObject JSONCityObject = (JSONObject) JSONWeatherObject.get("city");
        JSONObject JSONCityCoordinates = (JSONObject) JSONCityObject.get("coord");
        double JSONCityLatitude = (double) JSONCityCoordinates.get("lat");
        double JSONCityLongitude = (double) JSONCityCoordinates.get("lon");

        int minimumTemp = 100;
        int maximumTemp = -100;

        for (int i = 0; i < 24; i++) {
            JSONObject threeHourData = (JSONObject) JSONArrayList.get(i);
            JSONObject threeHourMain = threeHourData.getJSONObject("main");
            if (objectToCelsius(threeHourMain.get("temp_min")) < minimumTemp) {
                minimumTemp = objectToCelsius(threeHourMain.get("temp_min"));
            }
            if (objectToCelsius(threeHourMain.get("temp_max")) > maximumTemp) {
                maximumTemp = objectToCelsius(threeHourMain.get("temp_max"));
            }
            if (i == 7) {
                d1min = minimumTemp;
                d1max = maximumTemp;
                minimumTemp = 100;
                maximumTemp = -100;
            }
            if (i == 15) {
                d2min = minimumTemp;
                d2max = maximumTemp;
                minimumTemp = 100;
                maximumTemp = -100;
            }
            if (i == 23) {
                d3min = minimumTemp;
                d3max = maximumTemp;
            }
        }
        cityData.setLatitude(JSONCityLatitude);
        cityData.setLongitude(JSONCityLongitude);
        cityData.setTemperatures(d1min, d1max, d2min, d2max, d3min, d3max);
    }


    public void forecastPrinting() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(city + ".txt", true))) {
            String content = city + "\n"
                    + "Latitude: " + cityData.getLatitude() + ", longitude: " + cityData.getLongitude() + "\n"
                    + "Current forecast for 72 hours, min-max temperature in °C\n"
                    + "Day 1 minimum temperature: " + cityData.getDay1min() + "°C\n"
                    + "Day 1 maximum temperature: " + cityData.getDay1max() + "°C\n"
                    + "Day 2 minimum temperature: " + cityData.getDay2min() + "°C\n"
                    + "Day 2 maximum temperature: " + cityData.getDay2max() + "°C\n"
                    + "Day 3 minimum temperature: " + cityData.getDay3min() + "°C\n"
                    + "Day 3 maximum temperature: " + cityData.getDay3max() + "°C\n\n";
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void forecastToConsole() {
        System.out.println(city + "\n"
                + "Latitude: " + cityData.getLatitude() + ", longitude: " + cityData.getLongitude() + "\n"
                + "Current forecast for 72 hours, min-max temperature in °C\n"
                + "Day 1 minimum temperature: " + cityData.getDay1min() + "°C\n"
                + "Day 1 maximum temperature: " + cityData.getDay1max() + "°C\n"
                + "Day 2 minimum temperature: " + cityData.getDay2min() + "°C\n"
                + "Day 2 maximum temperature: " + cityData.getDay2max() + "°C\n"
                + "Day 3 minimum temperature: " + cityData.getDay3min() + "°C\n"
                + "Day 3 maximum temperature: " + cityData.getDay3max() + "°C\n");
    }


    public static int objectToCelsius(Object o) {
        return (int) (Double.parseDouble(o.toString()) - 273.15 + 0.5);
    }


    public String coordinatesFromDisk() throws Exception {
        return cityData.getLatitude() + " " + cityData.getLongitude();
    }


    public String lowMinimumHighMaximumForTest() {
        return cityData.getDay1min() + " " + cityData.getDay1max();
    }


    public String getForecastString() throws Exception {
        return HttpUtility.makeHttpGetRequest(forecastUrlStart + city + "&appid=" + apiCode);
    }


    public String getForecastFromDisk() throws Exception {
        return new String(Files.readAllBytes(Paths.get("Weather120hForecastTallinn.txt")));
    }


    public String getForecastForTesting() throws Exception {
        return new String(Files.readAllBytes(Paths.get("ExtremalForecastForTesting.txt")));
    }

}
