package gameOfLife;

public class GameOfLiveConsoleUI {
    void show(boolean[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j]) {
                    System.out.print("♥ ");
                } else {
                    System.out.print("☢ ");
                }
            }
            System.out.println();
        }
        System.out.println("===================");
    }
}
