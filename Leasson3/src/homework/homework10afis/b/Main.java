package homework10afis.b;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/staskosto/Documents/JAVA START/text.txt");
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculateABC(file));
    }



}
