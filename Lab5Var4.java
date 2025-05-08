import java.util.Scanner;

public class Lab5Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите границы отрезка [a, b] и точность epsilon:");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double epsilon = scanner.nextDouble();

                if (f(a) * f(b) >= 0) {
                    System.out.println("На отрезке нет корня или функция на границах одного знака");
                    break;
                }

                double root = findRoot(a, b, epsilon);
                System.out.println("Найденный корень: " + root);
                break;

            case 2:
                scanner.nextLine(); // Очистка буфера
                System.out.println("Введите строку:");
                String s = scanner.nextLine();
                System.out.println("Введите индексы i и j:");
                int i = scanner.nextInt();
                int j = scanner.nextInt();

                if (isSymmetric(s, i, j)) {
                    System.out.println("Часть строки симметрична");
                } else {
                    System.out.println("Часть строки не симметрична");
                }
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Функция для поиска корня (пример: f(x) = x^2 - 2)
    private static double f(double x) {
        return x * x - 2; // Ищем корень из 2
    }

    // Задание 1: Рекурсивный поиск корня методом деления отрезка пополам
    private static double findRoot(double a, double b, double epsilon) {
        double c = (a + b) / 2;
        if (Math.abs(b - a) < epsilon) {
            return c;
        }

        if (f(a) * f(c) < 0) {
            return findRoot(a, c, epsilon);
        } else {
            return findRoot(c, b, epsilon);
        }
    }

    // Задание 2: Рекурсивная проверка симметричности части строки
    private static boolean isSymmetric(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }

        return isSymmetric(s, i + 1, j - 1);
    }
}