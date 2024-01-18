package homework11afis.a;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkServise {

    public static String getHTMLCode(String spec, String code) throws IOException {
        URL url = new URL(spec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String result = "";
        try (InputStream is = connection.getInputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, code));
            String temp = "";
            for (;;) {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
                result += temp + System.lineSeparator();
            }

        } catch (IOException e) {
            throw e;
        }
        return result;
    }


}
