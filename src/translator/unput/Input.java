package translator.unput;

import java.util.Scanner;

public class Input {

    InputRus russian = new InputRus();
    InputEnglish english = new InputEnglish();
    Scanner scanner = new Scanner(System.in);
    public String response(boolean isEnglish) {
        String data = "";
        if (isEnglish) {
            System.out.println("Enter line on English here: ");
            data = english.getWordsToTranslate(scanner.nextLine());
        } else {
            System.out.println("Enter line on Russian here: ");
            data = russian.getWordsToTranslate(scanner.nextLine());
        }
        return data;
    }


}
