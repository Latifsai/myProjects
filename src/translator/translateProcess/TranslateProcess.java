package translator.translateProcess;


import translator.DataBase.TranslatesDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TranslateProcess {
    TranslatesDataBase translatesDataBase = new TranslatesDataBase();
    Scanner scanner = new Scanner(System.in);

    public StringBuilder translate(String dataForTranslate, boolean isEnglish) {
        StringBuilder translateResult = new StringBuilder();

        if (isEnglish) {
            translateResult = translateToRus(dataForTranslate);
        } else {
            translateResult = translateToEng(dataForTranslate);
        }
        return translateResult;
    }

    private StringBuilder translateToRus(String dataForTranslate) {
        StringBuilder result = new StringBuilder();

        List<String> list = prepareToTranslate(dataForTranslate);
        addElementForEnl(list);

        for (String str : list) {
            String element = translatesDataBase.getVocabularyEng().get(str);
            result.append(element).append(" ");
        }

        return result;
    }
    private StringBuilder translateToEng(String dataForTranslate) {
        StringBuilder result = new StringBuilder();

        List<String> list = prepareToTranslate(dataForTranslate);
        addElementForRus(list);
        for (String str : list) {
            String element = translatesDataBase.getVocabularyRus().get(str);
            result.append(element).append(" ");
        }
        return result;
    }

    private Map<String,String> addElementForRus(List<String> strings){
        for (int i = 0; i < strings.size(); i++) {
            if (!translatesDataBase.getVocabularyRus().containsKey(strings.get(i))){
                System.out.println("Enter the value of word " + strings.get(i)+ ": ");
                String value = scanner.nextLine();
                translatesDataBase.getVocabularyRus().put(strings.get(i), value);
            }
        }
        return translatesDataBase.getVocabularyRus();
    }
    private Map<String,String> addElementForEnl(List<String> strings){
        for (int i = 0; i < strings.size(); i++) {
            if (!translatesDataBase.getVocabularyEng().containsKey(strings.get(i))){
                System.out.println("Enter the value of word " + strings.get(i)+ ": ");
                String value = scanner.nextLine();
                 translatesDataBase.getVocabularyEng().put(strings.get(i), value);
            }
        }
        return translatesDataBase.getVocabularyEng();
    }


    private List<String> prepareToTranslate(String dataForTranslate) {
        String[] strings = dataForTranslate.split(" ");
        return new ArrayList<>(List.of(strings));
    }




}
