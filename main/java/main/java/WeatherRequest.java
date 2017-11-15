import currentweather.CurrentWeatherReport;
import forecast.Forecast;

public class WeatherRequest {


    public static void main(String[] args) throws Exception {
        CurrentWeatherReport current = new CurrentWeatherReport();
        System.out.println("Current weather report, temperature: " + current.currentWeatherReportTemperature() + "°C");

        System.out.println("\nCurrent forecast for 5 days, min-max temperature in °C");
        Forecast forecast = new Forecast();
        forecast.forecast();
    }

    public WeatherRequest() {

    }

    //"Tallinn", EE, metric
    public WeatherRequest(String cityName) {

    }

    public String getCountryName() {
        return "none";
    }

}
