import java.util.Vector;
import java.util.Random;
import java.util.Scanner;


//Первоначальное задание 17. Почитать количество столбцов заданной матрицы, которые составлены из попарно различных чисел.

//Изменённое задание:  программа  считывает матрицу целых чисел и выводит номера столбцов, в которых сумма элементов больше заданного значения.
//Также для этих столбцов нужно выводить среднее значение элементов.
public class task_17 {

  // Заполнение матрицы случайными значениями
    public static void matrixCreate(Integer[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100) - 50; // Генерация чисел от -50 до 49
            }
        }
    }

    // Вывод матрицы на экран
    public static void matrixPrint(Integer[][] matr) {
        System.out.println("Матрица:");
        for (Integer[] row : matr) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество строк в матрице: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Ошибка ввода, количество строк должно быть натуральным");
            return;
        }

        System.out.println("Введите количество столбцов в матрице: ");
        int m = sc.nextInt();
        if (m <= 0) {
            System.out.println("Ошибка ввода, количество столбцов должно быть натуральным");
            return;
        }

        System.out.println("Введите значение для сравнения суммы столбцов: ");
        int threshold = sc.nextInt();

        Integer[][] matr = new Integer[n][m];
        matrixCreate(matr);
        matrixPrint(matr);

        // Вывод номеров столбцов, сумма которых больше заданного значения
        System.out.println("Номера столбцов с суммой элементов больше " + threshold + ":");
        boolean foundColumns = false;

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matr[i][j]; // Суммируем элементы столбца
            }
            if (sum > threshold) {
                foundColumns = true;
                double average = (double) sum / n; // Среднее значение
                System.out.println("Столбец " + (j + 1) + ": сумма = " + sum + ", среднее = " + average);
            }
        }

        if (!foundColumns) {
            System.out.println("Нет столбцов с суммой элементов больше " + threshold);
        }

        sc.close(); // Закрываем сканер
    }
}
