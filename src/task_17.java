import java.util.Vector;
import java.util.Random;
import java.util.Scanner;


//17. Почитать количество столбцов заданной матрицы, которые составлены из попарно различных чисел.
public class task_17 {
    private int row;
    private int column;
    private Vector<Vector<Integer>> matrix;


    public void initializeMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк:");
        row = scanner.nextInt();
        System.out.println("Введите количество столбцов:");
        column = scanner.nextInt();
        Random random = new Random();
        matrix = new Vector<>(); // Создаем пустую матрицу
        // Заполнение матрицы случайными числами
        for (int i = 0; i < row; i++) {
            Vector<Integer> row = new Vector<>(); // Создаем новую строку
            for (int j = 0; j < column; j++) {
                row.add(random.nextInt(20)); // Генерация случайного числа
            }
            matrix.add(row); // Добавляем заполненную строку в матрицу
        }
    }


    // Метод для печати матрицы на экран
    public void printMatrix() {
        for (Vector<Integer> row : matrix) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }



    // Метод для подсчета количества уникальных столбцов
    public int countDistinctColumns() {
        int uniqueColumn_Count = 0; // Счетчик столбцов с попарно различными элементами
        // Проверка каждого столбца на уникальность значений
        for (int c = 0; c < column; c++) {
            Vector<Integer> Unique_Values = new Vector<>(); // Вектор для хранения различных элементов
            int uniqueValue_Count = 0; // Счетчик различных элементов  в текущем столбце
            for (int r = 0; r < row; r++) {
                int current_Value = matrix.get(row).get(c); // Получаем текущее значение из матрицы
                // Проверка, встречалось ли значение ранее
                if (!Unique_Values.contains(current_Value)) {
                    Unique_Values.add(current_Value); // Добавляем новое значение
                    uniqueValue_Count++;
                }
            }
            // Если количество уникальных значений равно количеству строк, увеличиваем счетчик уникальных столбцов
            if (uniqueValue_Count == row) {
                uniqueColumn_Count++;
            }
        }
        return uniqueColumn_Count;
    }


    // Метод для вывода номеров столбцов с попарно различными числами
    public void printDistinctColumnIndices() {
        Vector<Integer> distinctColumnIndices = new Vector<>(); // Вектор для хранения индексов уникальных столбцов
        // Проверка каждого столбца на уникальность значений
        for (int c = 0; c < column; c++) {
            Vector<Integer> seenValues = new Vector<>(); // Вектор для хранения уникальных значений в текущем столбце
            int uniqueValueCount = 0;
            for (int r = 0; r < row; r++) {
                int currentValue = matrix.get(r).get(c);
                // Проверка, встречалось ли значение ранее
                if (!seenValues.contains(currentValue)) {
                    seenValues.add(currentValue); // Добавляем новое значение
                    uniqueValueCount++;
                }
            }
            // Если количество уникальных значений равно количеству строк, добавляем номер столбца в вектор
            if (uniqueValueCount == row) {
                distinctColumnIndices.add(c + 1); // Добавляем номер столбца (с учетом того, что отсчёт начинается с 1)
            }
        }
        printDistinctColumns(distinctColumnIndices);
    }



    // Метод для печати номеров столбцов с попарно различными числами
    private void printDistinctColumns(Vector<Integer> distinctColumns) {
        System.out.print("Номера столбцов с попарно различными числами: ");
        for (int i = 0; i < distinctColumns.size(); i++) {
            System.out.print(distinctColumns.get(i) + (i < distinctColumns.size() - 1 ? ", " : ""));
        }
        System.out.println();
    }




    public static void main(String[] args) {
        task_17 main = new task_17 ();
        main.initializeMatrix();
        System.out.println("Матрица:");
        main.printMatrix();
        int distinctCount = main.countDistinctColumns();
        System.out.println("Общее количество столбцов с попарно различными числами: " + distinctCount);
        main.printDistinctColumnIndices();
    }
}