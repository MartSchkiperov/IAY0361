package weatherrequest;

import currentweather.CurrentWeather;
import forecast.Forecast;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherRequest {


    String city;


    public void manyCitiesWeatherInformation() throws Exception {
        List cities = allCitiesFromFile();
        for (int i = 0; i < cities.size(); i++) {
            city = cities.get(i).toString();
            Forecast forecast = new Forecast(city, "internet");
            forecast.forecast();
            CurrentWeather currentWeather = new CurrentWeather(city, "internet");
            currentWeather.writeCurrentWeather();
        }
    }


    public void oneCityWeatherInformation() throws Exception {
        city = "Tallinn";
        //city = cityFromConsole();
        //city = oneCityFromFile();

        Forecast forecast = new Forecast(city, "internet");
        forecast.forecast();
        CurrentWeather currentWeather = new CurrentWeather(city, "internet");
        currentWeather.writeCurrentWeather();
    }


    public void weatherInfoFromDisk() throws Exception {
        city = "Tallinn";
        Forecast forecast = new Forecast(city, "disk");
        forecast.forecast();
        CurrentWeather currentWeather = new CurrentWeather(city, "disk");
        currentWeather.writeCurrentWeather();
    }



    public List allCitiesFromFile() throws IOException {
        List<String> allCities = new ArrayList<>();
        InputStreamReader isr = null;
        File file0 = new File("input.txt");
        if (file0.isFile()) {
            try {
                isr = new InputStreamReader(new FileInputStream(file0));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try (Scanner scanner = new Scanner(isr)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                allCities.add(line);
            }
        }
        return allCities;
    }



    public String cityFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("City name:");
        return scanner.nextLine();
    }


    public String oneCityFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("inputOneCity.txt")));
    }

}
