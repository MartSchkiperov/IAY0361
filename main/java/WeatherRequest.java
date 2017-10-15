public class WeatherRequest {

    static String cityName = "Tallinn";
    static String weatherString = "";
    static String apiCode = "ed2d0441550bad29e87a82b03e7ff532";


    public static void main(String[] args) throws Exception {
        weatherString = HttpUtility.makeHttpGetRequest("http://api.openweathermap.org/data/2.5/forecast?q="
                + cityName + "&appid=" + apiCode);
        System.out.println(weatherString);
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
