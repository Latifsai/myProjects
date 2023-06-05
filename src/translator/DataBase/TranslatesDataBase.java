package translator.DataBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TranslatesDataBase {
    public Map<String, String> getVocabularyEng() {
        return vocabularyEng;
    }

    public Map<String, String> getVocabularyRus() {
        return vocabularyRus;
    }

    public TranslatesDataBase() {
        fillVocabularyEngToRus();
        fillVocabularyRusToEng();
    }

    private Map<String, String> vocabularyEng = new HashMap<>();
    private Map<String, String> vocabularyRus = new HashMap<>();

    private void fillVocabularyEngToRus(){
        vocabularyEng.put("I","Я");
        vocabularyEng.put("you","ты");
        vocabularyEng.put("she","она");
        vocabularyEng.put("he","он");
        vocabularyEng.put("it","это");
        vocabularyEng.put("we","мы");
        vocabularyEng.put("they","они");
        vocabularyEng.put("me","меня");
        vocabularyEng.put("wanna","хочу");
        vocabularyEng.put("to","");
        vocabularyEng.put("eat","есть");

    }

    private void fillVocabularyRusToEng() {
        Set<String> keys = vocabularyEng.keySet();
        for (String myKeys: keys) {
             String value = vocabularyEng.get(myKeys);
             vocabularyRus.put(value, myKeys);
        }

    }


}
