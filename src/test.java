package  GoogleStockReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test {
    public static void main(String[] argas) throws IOException {

        final String SYM = "GNC";
        URL url = new URL("https://www.google.co.uk/finance?q=NYSE%3AGNC&ei=6pwAWdHVPJadUtK5tvAM");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String price    = "not found";
        String line = buff.readLine();
        while (line != null) {
            if (line.contains("[\"GNC\",")){
                int target = line.indexOf(("[\"GNC\","));
                int deci = line.indexOf(",", target);
                int start = deci;
                while (line.charAt(start) != '\"') {
                    start--;
                }
                price = line.substring(start + 2, deci + 26);

            }
            line = buff.readLine();
        }
        System.out.println(price);
    }

}

