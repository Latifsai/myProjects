package gameOfLife;

import java.util.concurrent.TimeUnit;

public class GameLive {
    private GameOfLiveConsoleUI ui = new GameOfLiveConsoleUI();
    private GameOfLifeNextGenerationCalculator calculator = new GameOfLifeNextGenerationCalculator();
    private GameOfLiveRandomFiledGenerator generator = new GameOfLiveRandomFiledGenerator();

    public void run() {
        boolean[][] filed = generator.generate(10, 10);
        while (true) {
            ui.show(filed);
            sleepForSeconds(5);
            filed = calculator.calculateNextGeneration(filed);
        }
    }

    private void sleepForSeconds(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred!");
            System.exit(1);
        }
    }

}
