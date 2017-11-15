import com.sun.org.apache.xpath.internal.SourceTree;
import currentweather.CurrentWeatherReport;
import forecast.Forecast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WeatherRequest {

    static String city;

    public static void main(String[] args) throws Exception {
        city = "Tallinn";
        //city = cityFromConsole();
        city = cityFromFile();
        CurrentWeatherReport current = new CurrentWeatherReport();
        System.out.println("Current weather report, temperature: " + current.currentWeatherReportTemperature(city) + "°C");
        System.out.println("\nCurrent forecast for 5 days, min-max temperature in °C");
        Forecast forecast = new Forecast();
        forecast.forecast(city);
    }

    public WeatherRequest() {

    }

    //"Tallinn", EE, metric
    public WeatherRequest(String cityName) {

    }

    public String getCountryName() {
        return "none";
    }

    public static String cityFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("City name:");
        return scanner.nextLine();
    }

    public static String cityFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("city.txt")));
    }

}
