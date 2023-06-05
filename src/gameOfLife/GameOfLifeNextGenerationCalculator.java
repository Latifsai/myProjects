package gameOfLife;

public class GameOfLifeNextGenerationCalculator {

    public boolean[][] calculateNextGeneration(boolean[][] currentGeneration) {
        int rows = currentGeneration.length;  // Получаем количество строк в текущем поколении
        int columns = currentGeneration[0].length;  // Получаем количество столбцов в текущем поколении
        boolean[][] nextGeneration = new boolean[rows][columns];  // Создаем новый двумерный массив для следующего поколения клеток

        for (int row = 0; row < rows; row++) {  // Перебираем строки текущего поколения
            for (int col = 0; col < columns; col++) {  // Перебираем столбцы текущего поколения
                int liveNeighbors = countLiveNeighbors(currentGeneration, row, col);  // Вызываем метод для подсчета количества живых соседей у текущей клетки

                if (currentGeneration[row][col] && (liveNeighbors < 2 || liveNeighbors > 3)) {  // Проверяем условие для правила 1,2 игры "Жизнь"
                    nextGeneration[row][col] = false;  // Если клетка удовлетворяет условию, она умирает в следующем поколении
                } else if (currentGeneration[row][col] && (liveNeighbors == 2 || liveNeighbors == 3)){
                    nextGeneration[row][col] = currentGeneration[row][col];  // Клетка остается живой или остается мертвой в следующем поколении в соответствии с другими правилами
                }

                if (!currentGeneration[row][col] && liveNeighbors == 3) {
                    nextGeneration[row][col] = true;
                }
            }
        }

        return nextGeneration;  // Возвращаем новое поколение клеток
    }

    private int countLiveNeighbors(boolean[][] grid, int row, int col) {
        int liveNeighbors = 0;  // Переменная для подсчета количества живых соседей
        int rows = grid.length;  // Получаем количество строк в сетке клеток
        int columns = grid[0].length;  // Получаем количество столбцов в сетке клеток

        for (int i = -1; i <= 1; i++) {  // Перебираем соседние строки от -1 до 1
            for (int j = -1; j <= 1; j++) {  // Перебираем соседние столбцы от -1 до 1
                if (i == 0 && j == 0) {
                    continue;  // Пропускаем текущую клетку
                }

                int neighborRow = row + i;  // Вычисляем индекс соседней строки
                int neighborCol = col + j;  // Вычисляем индекс соседнего столбца

                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < columns) {
                    // Проверяем, находится ли соседняя клетка в пределах сетки
                    if (grid[neighborRow][neighborCol]) {  // Проверяем, является ли соседняя клетка живой
                        liveNeighbors++;  // Увеличиваем счетчик живых соседей
                    }
                }
            }
        }

        return liveNeighbors;  // Возвращаем количество живых соседей у заданной клетки
    }
}
