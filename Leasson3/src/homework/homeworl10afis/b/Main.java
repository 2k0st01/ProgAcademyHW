package homeworl10afis.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/staskosto/Documents/JAVA START/text.txt");

        try {
            calculeteABC(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void calculeteABC(File file) throws FileNotFoundException {
        Map<String, Integer> abc = new HashMap<>();
        Scanner sc = new Scanner(file);
        String wordsFromFile = sc.nextLine();
        String temp = "";

        while (sc.hasNextLine()) {
            wordsFromFile += sc.nextLine();
        }
        wordsFromFile = wordsFromFile.toLowerCase().replaceAll("\\W", "");
        char[] getTemp = wordsFromFile.toCharArray();

        for (int i = 0; i < getTemp.length; i++) {
            int counter = 0;
            temp = String.valueOf(getTemp[i]);
            for (int j = 0; j < getTemp.length; j++) {
                if (temp.equals(String.valueOf(getTemp[j]))) {
                    counter++;
                }
            }
            abc.put(temp, counter);
        }
        System.out.println(abc);
    }

}
