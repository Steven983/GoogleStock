package  GoogleStockReader;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test1 {
    public static void main(String[] argas) throws IOException {


        JFrame frame1 = new JFrame("GoogleStockReader");
        frame1.setBounds(300,200,220,350);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        final JTextField txtid = new JTextField();
        txtid.setBounds(100,200,200,200);
        txtid.setFont(new java.awt.Font("Lucida Grande", 0, 19));
        txtid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtid.setVisible(true);

        frame1.setVisible(true);
        frame1.add(txtid);
        final String SYM = "GNC";
        URL url = new URL("https://www.google.co.uk/finance?q=NYSE:GNC&ei=6pwAWdHVPJadUtK5tvAM");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String price = "not found";
        String line = buff.readLine();
        while (line != null) {
            if (line.contains("[\"GNC\",")) {
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
        txtid.setText(price);

    }
}

