package homework10afis.a;

import java.io.*;
import java.util.*;

public class Dictionary {
    Scanner sc = new Scanner(System.in);

    public void addWordInDictionary(File save) {
        Map<String, String> saveWords = new HashMap<>();
        System.out.println("Write the English word: ");
        String eng = sc.nextLine();
        System.out.println("Write a translation in Ukrainian: ");
        String ua = sc.nextLine();
        saveWords.put(eng, ua);
        saveWordsToCSVFile(save, saveWords);
    }

    private void saveWordsToCSVFile(File save, Map<String, String> saveWords) {
        Set<String> keys = saveWords.keySet();
        try (PrintWriter pw = new PrintWriter(new FileWriter(save, true))) {
            for (String k : keys) {
                pw.println(k + ";" + saveWords.get(k));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWordFromDictionary(File file) {
        Map<String, String> dictionary = new HashMap<>();
        Set<String> keys = dictionary.keySet();
        String[] tempStringForGetWordsFromFileCSV;
        System.out.println("Write the word you want to find.");
        String word = sc.nextLine();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                tempStringForGetWordsFromFileCSV = sc.nextLine().split(";");
                dictionary.put(tempStringForGetWordsFromFileCSV[0], tempStringForGetWordsFromFileCSV[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String k : keys) {
            if (word.equals(k)) {
                return k + " = " + dictionary.get(k);
            } else if(word.equals(dictionary.get(k))){
                return k + " = " + dictionary.get(k);
            }
        }
        return "You don't have this word in your dictionary";
    }
}