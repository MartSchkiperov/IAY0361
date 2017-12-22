package weatherrequest;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeatherRequestTest extends WeatherRequest {


    WeatherRequest wR = new WeatherRequest();


    @Test
    public void citiesFromFileToCorrectCityList() throws IOException {
        boolean compare = true;
        List<String> cities1 = new ArrayList<>(Arrays.asList("Tallinn", "Moscow", "Riga", "Helsinki"));
        List cities2 = wR.allCitiesFromFile();
        for (int i = 0; i < cities2.size(); i++) {
            if (!cities1.get(i).equals(cities2.get(i)))
                compare = false;
        }
        assertEquals(true, compare);
    }


    @Test
    public void cityListCorrectSize() throws IOException {
        List cities = wR.allCitiesFromFile();
        assertEquals(4, cities.size());
    }


    @Test
    public void oneCityIsTallinn() throws IOException {
        assertEquals("Tallinn", wR.oneCityFromFile());
    }


}
