package gameOfLife;

import java.util.Random;
import java.util.Scanner;

public class GameOfLiveRandomFiledGenerator {
    Random random = new Random();

    public boolean[][] generate(int fieldWidth, int fieldHeight) {
        boolean[][] field = new boolean[fieldWidth][fieldHeight];

        System.out.println("Enter amount of cells you want:");
        for (int i = 0; i < 56; i++) {
            field[random.nextInt(fieldWidth)][random.nextInt(fieldHeight)] = true;
        }


        return field;
    }


}

