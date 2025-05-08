import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lab8Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размеры матрицы n и m:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        // Заполняем матрицу случайными числами от -50 до 50
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(101) - 50;
            }
        }

        System.out.println("Сгенерированная матрица:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Простые числа в матрице:");
                printPrimeNumbers(matrix);
                break;

            case 2:
                int[] firstNegIndices = findFirstNegativeInRows(matrix);
                System.out.println("Индексы первых отрицательных элементов в строках:");
                System.out.println(Arrays.toString(firstNegIndices));
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Поиск простых чисел
    private static void printPrimeNumbers(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (isPrime(num)) {
                    System.out.print(num + " ");
                }
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Задание 2: Поиск первых отрицательных в строках
    private static int[] findFirstNegativeInRows(int[][] matrix) {
        int[] indices = new int[matrix.length];
        Arrays.fill(indices, -1); // -1 означает, что в строке нет отрицательных

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    indices[i] = j;
                    break;
                }
            }
        }
        return indices;
    }
}