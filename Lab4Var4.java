import java.util.Scanner;
import java.util.ArrayList;

public class Lab4Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите K и N:");
                int K = scanner.nextInt();
                int N = scanner.nextInt();

                ArrayList<Integer> numbers = findNumbersWithDigitSum(K, N);
                System.out.println("Числа с суммой цифр " + K + " и не больше " + N + ":");
                System.out.println(numbers);
                break;

            case 2:
                System.out.println("Введите две дроби A/B и C/D:");
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                int C = scanner.nextInt();
                int D = scanner.nextInt();

                subtractFractions(A, B, C, D);
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Найти числа с суммой цифр K, не превышающие N
    private static ArrayList<Integer> findNumbersWithDigitSum(int K, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (sumOfDigits(i) == K) {
                result.add(i);
            }
        }
        return result;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Задание 2: Вычитание дробей с приведением к несократимому виду
    private static void subtractFractions(int A, int B, int C, int D) {
        if (B == 0 || D == 0) {
            System.out.println("Знаменатель не может быть нулем");
            return;
        }

        // Находим общий знаменатель
        int commonDenominator = B * D;
        int numerator = A * D - C * B;

        // Сокращаем дробь
        int gcd = findGCD(Math.abs(numerator), Math.abs(commonDenominator));
        numerator /= gcd;
        commonDenominator /= gcd;

        System.out.printf("Результат: %d/%d\n", numerator, commonDenominator);
    }

    // Наибольший общий делитель (алгоритм Евклида)
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}