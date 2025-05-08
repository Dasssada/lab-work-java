import java.util.Scanner;
import java.lang.Math;

public class Lab2Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1, 2 или 3):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите x:");
                double x = scanner.nextDouble();
                double result;
                if (x <= 1) {
                    result = 0;
                } else {
                    result = 1 / (x + 6);
                }
                System.out.println("f(x) = " + result);
                break;

            case 2:
                System.out.println("Введите два различных числа:");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();

                if (a == b) {
                    System.out.println("Числа должны быть разными");
                    break;
                }

                double min = Math.min(a, b);
                double max = Math.max(a, b);
                double halfSum = (a + b) / 2;
                double doubleProd = 2 * a * b;

                a = (a == min) ? halfSum : doubleProd;
                b = (b == min) ? halfSum : doubleProd;

                System.out.println("Результат: " + a + " и " + b);
                break;

            case 3:
                System.out.println("Введите координаты трех точек A(x1,y1), B(x2,y2), C(x3,y3):");
                double x1 = scanner.nextDouble();
                double y1 = scanner.nextDouble();
                double x2 = scanner.nextDouble();
                double y2 = scanner.nextDouble();
                double x3 = scanner.nextDouble();
                double y3 = scanner.nextDouble();

                // Проверка на коллинеарность
                double area = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
                if (Math.abs(area) < 1e-10) {
                    System.out.println("Точки лежат на одной прямой");
                } else {
                    // Вычисляем векторы BA и BC
                    double baX = x1 - x2;
                    double baY = y1 - y2;
                    double bcX = x3 - x2;
                    double bcY = y3 - y2;

                    // Вычисляем угол между векторами
                    double dotProduct = baX * bcX + baY * bcY;
                    double baLength = Math.sqrt(baX * baX + baY * baY);
                    double bcLength = Math.sqrt(bcX * bcX + bcY * bcY);

                    double cosAngle = dotProduct / (baLength * bcLength);
                    double angle = Math.acos(cosAngle) * 180 / Math.PI;

                    System.out.println("Угол ABC = " + angle + " градусов");
                }
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }
}