package currentweather;

import httputility.HttpUtility;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CurrentWeather {

    public String currentWeatherReportUrlStart = "http://api.openweathermap.org/data/2.5/weather?q=";
    public String apiCode = "ed2d0441550bad29e87a82b03e7ff532";
    //http://api.openweathermap.org/data/2.5/weather?q=tallinn&appid=ed2d0441550bad29e87a82b03e7ff532
    JSONObject JSONObjectNow;
    String city;


    public CurrentWeather(String city, String purpose) throws Exception {
        this.city = city;
        if (purpose.equals("internet")) {
            this.JSONObjectNow = new JSONObject(getCurrentWeatherString());
        }
        if (purpose.equals("disk")) {
            this.JSONObjectNow = new JSONObject(getCurrentWeatherInDisk());
        }
        if (purpose.equals("testing")) {
            this.JSONObjectNow = new JSONObject(getCurrentWeatherForTesting());
        }
    }


    public void writeCurrentWeather() throws Exception {
        JSONObject mainNow = (JSONObject) JSONObjectNow.get("main");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(city + ".txt", true))) {
            String content = "Current temperature: "
                    + objectToCelsius(mainNow.get("temp")) + "°C\n\n";
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Current temperature: "
                + objectToCelsius(mainNow.get("temp")) + "°C\n");
    }


    public int currentWeatherTemperature() throws Exception {
        JSONObject mainNow = (JSONObject) JSONObjectNow.get("main");
        return objectToCelsius(mainNow.get("temp"));
    }


    public static int objectToCelsius(Object o) {
        return (int) (Double.parseDouble(o.toString()) - 273.15 + 0.5);
    }


    public String getCurrentWeatherString() throws Exception {
        return HttpUtility.makeHttpGetRequest(currentWeatherReportUrlStart + city + "&appid=" + apiCode);
    }

    public String getCurrentWeatherInDisk() throws Exception {
        return new String(Files.readAllBytes(Paths.get("PastCurrentWeatherTallinn.txt")));
    }

    public String getCurrentWeatherForTesting() throws Exception {
        return new String(Files.readAllBytes(Paths.get("CurrentWeatherForTesting.txt")));
    }


}
