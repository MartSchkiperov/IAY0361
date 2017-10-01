import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherRequestTest extends WeatherRequest {

    @Test
    public void testIfWeatherRepositoryRespCityEqualsReqCity() { // ← Testi nimi ütleb mida testid!
        /*
        try{
            // given
            /// WeatherRequest request = new WeatherRequest("Tallinn", EE, metric);
            WeatherRequest request = new WeatherRequest("Tallinn");
            CurrentWeatherRepository repository = new CurrentWeatherRepository();
            // when
            CurrentWeatherReport report = repository.getCurrentWeather(request);
            // then (no null check!)
            assertEquals(report.cityName, request.cityName);
        } catch (Exception e){
            fail("Failure cause: " + e.getMessage());
        }
        */
    }
}
