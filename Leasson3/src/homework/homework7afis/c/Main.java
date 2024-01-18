package homework7afis.c;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String fileName =("text.txt");
        File folderName = new File("/Users/staskosto/Documents/123");
        MultiFileSearcher mfs = new MultiFileSearcher(fileName,folderName);
        Thread th = new Thread(mfs);

        th.start();


    }
}
