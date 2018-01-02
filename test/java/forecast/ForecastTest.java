package forecast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForecastTest {

    String city = "Tallinn";
    Forecast forecast = new Forecast(city, "testing");

    public ForecastTest() throws Exception {
    }

    @Test
    public void urlIsCorrect() {
        assertEquals("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=ed2d0441550bad29e87a82b03e7ff532",
                forecast.forecastUrlStart + city + "&appid=" + forecast.apiCode);
    }

    @Test
    public void correctCoordinates() throws Exception {
        forecast.forecastJSONProcessing();
        assertEquals("59.4372 24.7454", forecast.coordinatesFromDisk());
    }

    @Test
    public void lowMinimumHighMaximumForTest() throws Exception {
        forecast.forecastJSONProcessing();
        assertEquals("-50 50", forecast.lowMinimumHighMaximumForTest());
    }

}