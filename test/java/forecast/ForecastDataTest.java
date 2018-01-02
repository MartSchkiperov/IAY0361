package forecast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForecastDataTest {

    String city = "Tallinn";
    ForecastData forecastData = new ForecastData(city);


    @Test
    public void latitude() {
        forecastData.setLatitude(1.0);
        assertEquals(1.0, forecastData.getLatitude(), 0.1);
    }


    @Test
    public void longitude() {
        forecastData.setLongitude(6.0);
        assertEquals(6.0, forecastData.getLongitude(), 0.1);
    }


    @Test
    public void veryCold() {
        forecastData.temperatures.add(-50);
        assertEquals(-50, forecastData.getDay1min());
    }

    @Test
    public void veryHot() {
        forecastData.temperatures.add(-40);
        forecastData.temperatures.add(60);
        assertEquals(60, forecastData.getDay1max());
    }


}