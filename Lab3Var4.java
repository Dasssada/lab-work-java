import java.util.Scanner;
import java.lang.Math;

public class Lab3Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1, 2 или 3):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите длину палки x (в метрах):");
                double x = scanner.nextDouble();
                System.out.println("Введите шаг h (в метрах):");
                double h = scanner.nextDouble();

                System.out.println("y (м) | угол α (градусы)");
                System.out.println("---------------------");
                for (double y = 2; y <= 3 + 1e-9; y += h) {
                    if (y > x) {
                        System.out.println(y + " | Невозможно (y > x)");
                        continue;
                    }
                    double angle = Math.acos(y / x) * 180 / Math.PI;
                    System.out.printf("%.2f | %.2f\n", y, angle);
                }
                break;

            case 2:
                System.out.println("Введите натуральное число N:");
                int n = scanner.nextInt();
                double sum = 0;

                for (int i = 1; i <= n; i++) {
                    double numerator = 0;
                    double denominator = 0;

                    for (int j = 1; j <= i; j++) {
                        numerator += Math.cos(j);
                        denominator += Math.sin(j);
                    }

                    sum += Math.cos(i) / numerator * Math.sin(i) / denominator;
                }

                System.out.println("Сумма ряда: " + sum);
                break;

            case 3:
                double epsilon = 0.001;
                double sumSeries = 0;
                int nTerm = 1;
                double term;

                do {
                    term = 1.0 / ((3 * nTerm - 2) * (3 * nTerm + 1));
                    sumSeries += term;
                    nTerm++;
                } while (term >= epsilon);

                System.out.println("Сумма ряда с точностью 0.001: " + sumSeries);
                System.out.println("Количество слагаемых: " + (nTerm - 1));
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }
}