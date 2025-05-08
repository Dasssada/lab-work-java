import java.util.Scanner;

public class Lab6Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch(task) {
            case 1:
                System.out.println("Введите строку:");
                String str = scanner.nextLine();
                System.out.println("Результат: " + removeMiddleChars(str));
                break;

            case 2:
                System.out.println("Введите исходную строку:");
                String source = scanner.nextLine();
                System.out.println("Введите подстроку для замены:");
                String str1 = scanner.nextLine();
                System.out.println("Введите подстроку замены:");
                String str2 = scanner.nextLine();
                System.out.println("Результат: " + replaceAllOccurrences(source, str1, str2));
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Удаление средних символов
    private static String removeMiddleChars(String str) {
        if (str.isEmpty()) return str;

        int length = str.length();
        if (length % 2 == 1) {
            // Нечетная длина - удаляем одну среднюю букву
            int mid = length / 2;
            return str.substring(0, mid) + str.substring(mid + 1);
        } else {
            // Четная длина - удаляем две средние буквы
            int mid = length / 2 - 1;
            return str.substring(0, mid) + str.substring(mid + 2);
        }
    }

    // Задание 2: Замена всех вхождений подстроки
    private static String replaceAllOccurrences(String source, String str1, String str2) {
        return source.replace(str1, str2);
    }
}