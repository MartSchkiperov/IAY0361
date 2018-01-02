package forecast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ForecastWriting {

    ForecastData cityData;


    public ForecastWriting(ForecastData cityData) {
        this.cityData = cityData;
    }


    public void forecastWriting() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cityData.getCity() + ".txt", true))) {
            String content = cityData.getCity() + "\n"
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

    public void simpleWriting(String string) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("simple.txt", true))) {
            String content = string;
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
