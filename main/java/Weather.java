import weatherrequest.WeatherRequest;

public class Weather {


    public static void main(String[] args) throws Exception {
        WeatherRequest wR = new WeatherRequest();

        //wR.manyCitiesWeatherInformation();

        //wR.oneCityWeatherInformation();

        wR.weatherInfoFromDisk();

    }
}
