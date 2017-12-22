package currentweather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 1.10.2017.
 */
public class CurrentWeatherTest {

    CurrentWeather w = new CurrentWeather("Tallinn", "testing");

    public CurrentWeatherTest() throws Exception {
    }


    @Test
    public void urlIsCorrect() {
        assertEquals("http://api.openweathermap.org/data/2.5/weather?q=tallinn&appid=ed2d0441550bad29e87a82b03e7ff532",
                w.currentWeatherReportUrlStart + "tallinn" + "&appid=" + w.apiCode);
    }

    @Test
    public void currentTemperatureIsNotTooCold() throws Exception {
        assertTrue(w.currentWeatherTemperature() > -50);
    }

    @Test
    public void currentTemperatureIsNotTooHot() throws Exception {
        assertTrue(w.currentWeatherTemperature() < 50);
    }


}