package homework11afis.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/staskosto/Documents/123/3/3/text.txt");

        try (Scanner sc = new Scanner(file)) {
            for (; sc.hasNextLine();) {
                String str = sc.nextLine();
                try {
                    URL url = new URL(str);
                    HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                    if (urlc.getResponseCode() == 200) {
                        System.out.println(str + "is Available");
                    } else {
                        System.out.println(str + " is not Available");
                    }
                } catch (IOException e) {
                    System.out.println("Address is not Available");
                }
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
