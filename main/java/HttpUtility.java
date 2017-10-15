import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtility {


    public static String makeHttpGetRequest(String urlToGet) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToGet);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = read.readLine()) != null) {
            result.append(line);
        }
        read.close();
        return result.toString();
    }


}
