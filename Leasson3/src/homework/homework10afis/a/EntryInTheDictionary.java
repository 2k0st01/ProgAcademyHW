package homework10afis.a;

import java.io.*;
import java.util.*;

public class EntryInTheDictionary {
    Scanner sc = new Scanner(System.in);
    Map<String, String> saveWords = new HashMap<>();

    public void addWords(File save) {
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

    public String getWord(File file) {
        Map<String, String> dictionary = new HashMap<>();
        Set<String> keys = dictionary.keySet();
        String[] temp;
        System.out.println("Write the word you want to find.");
        String word = sc.nextLine();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                temp = sc.nextLine().split(";");
                dictionary.put(temp[0], temp[1]);
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