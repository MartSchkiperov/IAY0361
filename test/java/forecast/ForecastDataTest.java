package forecast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForecastDataTest {

    ForecastData fd = new ForecastData("Tallinn");


    @Test
    public void latitude() {
        fd.setLatitude(1.0);
        assertEquals(1.0, fd.getLatitude(), 0.1);
    }


    @Test
    public void longitude() {
        fd.setLongitude(6.0);
        assertEquals(6.0, fd.getLongitude(), 0.1);
    }


    @Test
    public void veryCold() {
        fd.temperatures.add(-50);
        assertEquals(-50, fd.getDay1min());
    }

    @Test
    public void veryHot() {
        fd.temperatures.add(-40);
        fd.temperatures.add(60);
        assertEquals(60, fd.getDay1max());
    }


}