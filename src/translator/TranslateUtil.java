package translator;

import translator.translateProcess.TranslateProcess;
import translator.unput.Input;

public class TranslateUtil {
    TranslateProcess translateProcess = new TranslateProcess();
    Input input = new Input();

    public void run() {

        while (true) {
            String dataToTranslateEng = input.response(true);
            String dataToTranslateRus = input.response(false);
            if (!dataToTranslateEng.equals("0") || !dataToTranslateRus.equals("0")) {
                System.out.println("TRANSLATE ENG -> RUS: ");
                System.out.println(translateProcess.translate(dataToTranslateEng, true));

                System.out.println("TRANSLATE RUS -> ENG: ");
                System.out.println(translateProcess.translate(dataToTranslateRus, false));
            }else {
                break;
            }
        }

    }

}
