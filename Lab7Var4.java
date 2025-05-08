import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lab7Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Заполняем массив случайными числами от -50 до 50
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101) - 50;
        }

        System.out.println("Сгенерированный массив: " + Arrays.toString(array));

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите границы A и B:");
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                System.out.println("Сумма элементов в промежутке: " + sumInRange(array, A, B));
                break;

            case 2:
                int[] oddResults = countAndSumOddElements(array);
                System.out.println("Количество нечетных элементов: " + oddResults[0]);
                System.out.println("Сумма нечетных элементов: " + oddResults[1]);
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Сумма элементов в диапазоне [A, B]
    private static int sumInRange(int[] arr, int A, int B) {
        int sum = 0;
        for (int num : arr) {
            if (num >= A && num <= B) {
                sum += num;
            }
        }
        return sum;
    }

    // Задание 2: Подсчет и сумма нечетных элементов
    private static int[] countAndSumOddElements(int[] arr) {
        int count = 0;
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
                sum += num;
            }
        }
        return new int[]{count, sum};
    }
}