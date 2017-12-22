import forecast.Forecast;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import static org.junit.Assert.assertTrue;

public class MockTest {


    private Forecast weatherDataRequesterMockObj;
    private JSONObject weatherResponse;
    private JSONObject forecastResponse;
    private Writer mockedFileWriter;


    @Before
    public void setup() throws IOException {
        this.mockedFileWriter = Mockito.mock(Writer.class);
        this.weatherDataRequesterMockObj = Mockito.mock(Forecast.class);
        //this.currentWeatherResponse = CurrentWeather.readFromFile("CurrentWeatherForTesting.txt");
        //Forecast forecast = new Forecast();
        //this.forecastResponse = forecast.forecastJSONProcessing("ExtremalForecastForTesting.txt");
    }

    @Test
    public void createNewFileTest() throws IOException {
        this.mockedFileWriter.write(Mockito.anyString());
        assertTrue(new File("").list().length > 0);
    }


}
