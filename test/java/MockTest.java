import forecast.Forecast;
import forecast.ForecastData;
import forecast.ForecastWriting;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockTest {

    private Forecast forecast;
    private ForecastData forecastData;
    private ForecastWriting forecastWriting;

    @Test
    public void forecastDataSetLatitude() {
        forecastData = mock(ForecastData.class);

        forecastData.setLatitude(12.34);
        verify(forecastData).setLatitude(12.34);
    }

    @Test
    public void forecastDataGetLatitudeWithStubbing() {
        forecastData = mock(ForecastData.class);

        assertEquals(0, forecastData.getLatitude(), 0.0);

        when(forecastData.getLatitude()).thenReturn(12.34);
        assertEquals(12.34, forecastData.getLatitude(), 0.1);
    }


    @Test
    public void forecastDataSetTemperatures() {
        forecastData = mock(ForecastData.class);

        forecastData.setTemperatures(0, 1, 1, 2, 2, 3);
        verify(forecastData).setTemperatures(0, 1, 1, 2, 2, 3);
    }


    @Test
    public void forecastDataGetTemperatureWithStubbing() {
        forecastData = mock(ForecastData.class);

        assertEquals(0, forecastData.getDay1max());

        when(forecastData.getDay1max()).thenReturn(1);
        assertEquals(1, forecastData.getDay1max());
    }


    @Test
    public void forecastWritingForecastWriting() throws IOException {
        forecastWriting = mock(ForecastWriting.class);

        forecastWriting.forecastWriting();
        verify(forecastWriting).forecastWriting();
    }

    @Test
    public void forecastWritingSimpleWriting() throws IOException {
        forecastWriting = mock(ForecastWriting.class);

        forecastWriting.simpleWriting(Mockito.anyString());
        verify(forecastWriting).simpleWriting(Mockito.anyString());
    }

}
