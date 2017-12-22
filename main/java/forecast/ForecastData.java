package forecast;

import java.util.ArrayList;
import java.util.List;

public class ForecastData {

    String city;
    double latitude;
    double longitude;
    List<Integer> temperatures = new ArrayList<>();


    public ForecastData(String city) {
        this.city = city;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTemperatures(int d1min, int d1max, int d2min, int d2max, int d3min, int d3max) {
        temperatures.add(d1min);
        temperatures.add(d1max);
        temperatures.add(d2min);
        temperatures.add(d2max);
        temperatures.add(d3min);
        temperatures.add(d3max);
    }

    public int getDay1min() {
        return temperatures.get(0);
    }

    public int getDay1max() {
        return temperatures.get(1);
    }

    public int getDay2min() {
        return temperatures.get(2);
    }

    public int getDay2max() {
        return temperatures.get(3);
    }

    public int getDay3min() {
        return temperatures.get(4);
    }

    public int getDay3max() {
        return temperatures.get(5);
    }

}
