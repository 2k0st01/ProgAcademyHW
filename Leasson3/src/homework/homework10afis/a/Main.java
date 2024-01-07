package homework10afis.a;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Dictionary Dictionary = new Dictionary();
        File save = new File("save.csv");

        Dictionary.addWordInDictionary(save);
        System.out.println(Dictionary.getWordFromDictionary(save));
    }
}
