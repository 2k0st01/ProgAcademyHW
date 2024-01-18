package homework11afis.a;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String spec = "https://dou.ua/";
        File file = new File("Save_HTML_Links.txt");

        saveURLFile(spec, file);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String text = "";
            for (; (text = br.readLine()) != null;) {
                System.out.println(text);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveURLFile(String spec, File file) {
        try (PrintWriter pr = new PrintWriter(file)){
            String html = NetworkServise.getHTMLCode(spec, "UTF-8");
            String[] s = html.split("http");
            for (int i = 1; i < s.length; i++) {
                int index = 0;
                s[i] = "http" + s[i].replaceAll("\'", "\"");
                if (s[i].indexOf("\"") != -1) {
                    index = s[i].indexOf("\"");
                }
                pr.print(s[i].substring(0, index) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
