package homework10afis.a;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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

    public String getTheWordTranslationFromTheDictionary(File file) {
        String[] tempStringForGetWordsFromFileCSV;
        System.out.println("Write the word you want to find.");
        String word = sc.nextLine();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                tempStringForGetWordsFromFileCSV = sc.nextLine().split(";");
                if (tempStringForGetWordsFromFileCSV[0].equals(word) || tempStringForGetWordsFromFileCSV[1].equals(word)) {
                    return tempStringForGetWordsFromFileCSV[0] + " = " + tempStringForGetWordsFromFileCSV[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "You don't have this word in your dictionary";
    }

    public Map<String, String> getAllWordsFromDictionary(File file) {
        Map<String, String> dictionary = new HashMap<>();
        String[] tempStringForGetWordsFromFileCSV;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                tempStringForGetWordsFromFileCSV = sc.nextLine().split(";");
                dictionary.put(tempStringForGetWordsFromFileCSV[0], tempStringForGetWordsFromFileCSV[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dictionary;
    }
}