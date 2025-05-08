import java.util.Scanner;
import java.lang.Math;

public class Lab1Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1, 2 или 3):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите x и y:");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double result1 = x*y - (Math.pow(x,3) - Math.pow(y,3))/(Math.pow(x,2) + 2*x*y + Math.pow(y,2));
                System.out.println("Результат: " + result1);
                break;

            case 2:
                System.out.println("Введите x (x > 0):");
                double x2 = scanner.nextDouble();
                if (x2 <= 0) {
                    System.out.println("x должен быть больше 0");
                    break;
                }
                double result2 = Math.pow(x2,3) * Math.log(x2) + Math.log(4*Math.sqrt(x2) + 5);
                System.out.println("Результат: " + result2);
                break;

            case 3:
                System.out.println("Введите стороны треугольника a, b, c:");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();

                if (a + b <= c || a + c <= b || b + c <= a) {
                    System.out.println("Такого треугольника не существует");
                    break;
                }

                double p = (a + b + c) / 2;
                double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

                double ha = 2 * area / a;
                double hb = 2 * area / b;
                double hc = 2 * area / c;

                System.out.println("Высота к стороне a: " + ha);
                System.out.println("Высота к стороне b: " + hb);
                System.out.println("Высота к стороне c: " + hc);
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }
}