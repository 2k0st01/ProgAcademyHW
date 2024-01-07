package homework10afis.a;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        EntryInTheDictionary entryInTheDictionary = new EntryInTheDictionary();
        File save = new File("save.csv");

        entryInTheDictionary.addWords(save);
        System.out.println(entryInTheDictionary.getWord(save));

    }
}
