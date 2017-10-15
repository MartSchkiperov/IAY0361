import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherRequest {

    static String cityName = "Tallinn";
    static String weather = "";
    static String apiCode = "ed2d0441550bad29e87a82b03e7ff532";
    static double round;
    static String min = "";
    static String max = "";
    static String add = "";
    static String noMinus = "";
    static String oldDate = "";


    public static void main(String[] args) throws Exception {
        weather = HttpUtility.makeHttpGetRequest("http://api.openweathermap.org/data/2.5/forecast?q="
                + cityName + "&appid=" + apiCode);
        for (int i = 0; i < weather.length(); i++) {
            if (weather.substring(i).startsWith("temp_min")) {
                for (int j = 13; j < 18; j++) {
                    if (weather.substring(i + j, i + j + 1).equals(",")) {
                        round = Math.round((Double.parseDouble(weather.substring(i + 10, i + j)) - 273.15) * 10.0) / 10.0;
                        if ((round + "").length()< 4) add = " ";
                        if (round >= 0) noMinus = " ";
                        min = "min:" + add + noMinus + round + "°C";
                        add = "";
                        noMinus = "";
                        // min = "min: " + temperatureFormat(weather.substring(i + 10, i + j));
                    }
                }
            }
            if (weather.substring(i).startsWith("temp_max")) {
                for (int j = 13; j < 18; j++) {
                    if (weather.substring(i + j, i + j + 1).equals(",")) {
                        round = Math.round((Double.parseDouble(weather.substring(i + 10, i + j)) - 273.15) * 10.0) / 10.0;
                        if ((round + "").length()< 4) add = " ";
                        if (round >= 0) noMinus = " ";
                        max = "max:" + add + noMinus + round + "°C";
                        add = "";
                        noMinus = "";
                    }
                }
            }
            if (weather.substring(i).startsWith("dt_txt")) {
                DateTimeFormatter formatAPI = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(weather.substring(i + 9, i + 25), formatAPI);
                DateTimeFormatter formatEST = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
                DateTimeFormatter formatESTtime = DateTimeFormatter.ofPattern("HH:mm");
                if (!weather.substring(i + 9, i + 19).equals(oldDate)) {
                    System.out.println(dateTime.format(formatEST) + "  " + min + "  " + max);
                    oldDate = weather.substring(i + 9, i + 19);
                } else System.out.println("         " + dateTime.format(formatESTtime) + "  " + min + "  " + max);
            }
        }
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
