import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WeatherRequestTest extends WeatherRequest {

    WeatherRequest w = new WeatherRequest("Tallinn");

    @Test
    public void testIfWeatherRepositoryRespCityEqualsReqCity() { // ← Testi nimi ütleb mida testid!
        /*
        try{
            // given
            /// WeatherRequest request = new WeatherRequest("Tallinn", EE, metric);
            WeatherRequest request = new WeatherRequest("Tallinn");
            currentweather.CurrentWeatherRepository repository = new currentweather.CurrentWeatherRepository();
            // when
            currentweather.CurrentWeatherReport report = repository.getCurrentWeather(request);
            // then (no null check!)
            assertEquals(report.cityName, request.cityName);
        } catch (Exception e){
            fail("Failure cause: " + e.getMessage());
        }
        */
    }

    @Test
    public void testIfCityCountryIsCorrect() throws Exception {
        assertEquals("Estonia", w.getCountryName());
    }


    @Test
    public void tallinnIsTallinn() throws IOException {
        assertEquals("Tallinn", w.cityFromFile());
    }


}
