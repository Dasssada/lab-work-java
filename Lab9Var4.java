import java.io.*;
import java.util.Scanner;

public class Lab9Var4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch(task) {
            case 1:
                processNumbersFile();
                break;

            case 2:
                searchBooks();
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Подсчет пар противоположных чисел
    private static void processNumbersFile() {
        try {
            // Создаем файл с числами
            PrintWriter writer = new PrintWriter("numbers.txt");
            writer.println("3 -5 12 8 -12 0 4 -3 7 -8");
            writer.close();

            // Читаем файл
            Scanner fileScanner = new Scanner(new File("numbers.txt"));
            int[] numbers = new int[10];
            int count = 0;

            while (fileScanner.hasNextInt() && count < 10) {
                numbers[count++] = fileScanner.nextInt();
            }
            fileScanner.close();

            // Подсчет пар противоположных
            int oppositePairs = 0;
            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (numbers[i] == -numbers[j]) {
                        oppositePairs++;
                        System.out.println("Найдена пара: " + numbers[i] + " и " + numbers[j]);
                    }
                }
            }

            System.out.println("Всего пар противоположных чисел: " + oppositePairs);

        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом: " + e.getMessage());
        }
    }

    // Задание 2: Поиск книг по автору и году
    private static void searchBooks() {
        try {
            // Создаем файл с книгами
            PrintWriter writer = new PrintWriter("books.txt");
            writer.println("Толстой ВойнаИМир 1869");
            writer.println("Достоевский ПреступлениеИНаказание 1866");
            writer.println("Толстой АннаКаренина 1877");
            writer.println("Оруэлл 1984 1949");
            writer.println("Толстой ХаджиМурат 1912");
            writer.close();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите фамилию автора:");
            String author = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
            String line;
            boolean found = false;

            System.out.println("Книги автора " + author + ", изданные после 1960:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[0].equals(author)) {
                    int year = Integer.parseInt(parts[2]);
                    if (year > 1960) {
                        System.out.println(parts[1] + " (" + year + ")");
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("Книги не найдены");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом: " + e.getMessage());
        }
    }
}