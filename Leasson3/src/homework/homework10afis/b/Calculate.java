package homework10afis.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculate {

    public Map<String, Integer> calculateABC(File file) {
        Map<String, Integer> abc = new HashMap<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

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
        return abc;
    }

}
