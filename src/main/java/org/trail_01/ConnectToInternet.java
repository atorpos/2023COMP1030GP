package org.trail_01;
import java.net.*;
import java.io.*;

public class ConnectToInternet {
    String url_string = "https://www.google.com";
    public void checkconnection() {

        try {
            URI uri = new URI(url_string);
            URL url = uri.toURL();

            URLConnection newConnection = url.openConnection();
            newConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

            InputStreamReader isr = new InputStreamReader(newConnection.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();

            System.out.println(content.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void numebreffect() {
        int counter = 0;

        while (true) {
            System.out.print("\r" + counter); // \r is used to move the cursor back to the beginning of the line
            System.out.flush();
            counter++;

            try {
                Thread.sleep(1); // Sleep for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
