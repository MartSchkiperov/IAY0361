import currentweather.CurrentWeatherReport;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 1.10.2017.
 */
public class CurrentWeatherReportTest extends CurrentWeatherReport {

    CurrentWeatherReport w = new CurrentWeatherReport();

    @Test
    public void maximumTemperatureIsSmallerThan50DegreeCelsius() throws Exception {
        assertTrue(w.getMaximumTemperature() < 323);
    }

    @Test
    public void maximumTemperatureIsGreaterThanMinus50DegreeCelsius() throws Exception {
        assertTrue(w.getMaximumTemperature() > 223);
    }

    @Test
    public void minimumTemperatureIsSmallerThan50DegreeCelsius() throws Exception {
        assertTrue(w.getMinimumTemperature() < 323);
    }

    @Test
    public void minimumTemperatureIsGreaterThanMinus50DegreeCelsius() throws Exception {
        assertTrue(w.getMinimumTemperature() > 223);
    }

    @Test
    public void pressureIsGreatherThan900hPa() throws Exception {
        assertTrue(w.getPressure() > 900);
    }

    @Test
    public void pressureIsSmallerThan1100hPa() throws Exception {
        assertTrue(w.getPressure() < 1100);
    }

}