package forecast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForecastTest {

    Forecast f = new Forecast("Tallinn", "testing");

    public ForecastTest() throws Exception {
    }

    @Test
    public void urlIsCorrect() {
        assertEquals("http://api.openweathermap.org/data/2.5/forecast?q=tallinn&appid=ed2d0441550bad29e87a82b03e7ff532",
                f.forecastUrlStart + "tallinn" + "&appid=" + f.apiCode);
    }

    @Test
    public void correctCoordinates() throws Exception {
        f.forecastJSONProcessing();
        assertEquals("59.4372 24.7454", f.coordinatesFromDisk());
    }

    @Test
    public void lowMinimumHighMaximumForTest() throws Exception {
        f.forecastJSONProcessing();
        assertEquals("-50 50", f.lowMinimumHighMaximumForTest());
    }

}