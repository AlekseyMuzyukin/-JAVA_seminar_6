
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Task_01 {
    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        TreeMap<Integer, Laptop> notebooks = GetNotebookList();
        while (true) {
            PrintCriteria(menu(), notebooks);
        }
    }

    public static void PriceSort(TreeMap<Integer, Laptop> notebooks) {
        Map<Laptop, Integer> priceSort = new TreeMap<Laptop, Integer>(new PriceCompare());
        for (var el : notebooks.entrySet()) {
            priceSort.put(el.getValue(), el.getValue().price);
        }
        System.out.println("Название | Производитель | Процессор | RAM | HDD | OS | Цвет | Цена");
        for (var el : priceSort.entrySet()) {
            System.out.println(el.getKey().toString());
        }
    }

    public static void NameSort(TreeMap<Integer, Laptop> notebooks) {
        Map<Laptop, String> nameSort = new TreeMap<Laptop, String>(new NameCompare());
        for (var el : notebooks.entrySet()) {
            nameSort.put(el.getValue(), el.getValue().name);
        }
        System.out.println("Название | Производитель | Процессор | RAM | HDD | OS | Цвет | Цена");
        for (var el : nameSort.entrySet()) {
            System.out.println(el.getKey().toString());
        }
    }

    public static void PrintCriteria(int selection, TreeMap<Integer, Laptop> notebooks) {

        switch (selection) {
            case 1:
                System.out.println("Название | Процессор");
                for (var el : notebooks.entrySet())
                    System.out.println(el.getValue().name + " | " + el.getValue().processor);
                break;
            case 2:
                System.out.println("Название | RAM");
                for (var el : notebooks.entrySet())
                    System.out.println(el.getValue().name + " | " + el.getValue().RAMGB);
                break;
            case 3:
                System.out.println("Название | HDD");
                for (var el : notebooks.entrySet())
                    System.out.println(el.getValue().name + " | " + el.getValue().HDDGB);
                break;
            case 4:
                System.out.println("Название | OS");
                for (var el : notebooks.entrySet())
                    System.out.println(el.getValue().name + " | " + el.getValue().operatingSystem);
                break;
            case 5:
                System.out.println("Название | Цвет");
                for (var el : notebooks.entrySet())
                    System.out.println(el.getValue().name + " | " + el.getValue().color);
                break;
            case 6:
                System.out.println("Название | Цена");
                for (var el : notebooks.entrySet())
                    System.out.println(el.getValue().name + " | " + el.getValue().price);
                break;
            case 7:
                NameSort(notebooks);
                break;
            case 8:
                PriceSort(notebooks);
                break;
            case 9:
                System.exit(0);
        }
    }

    public static int menu() {
        int selection;
        System.out.println("Критерии фильтрации");
        System.out.println("-------------------------");
        System.out.println("1 - Процессор");
        System.out.println("2 - Объём оперативной памяти");
        System.out.println("3 - Объём жесткого диска");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Цвет");
        System.out.println("6 - Цена");
        System.out.println("7 - Сортировка по имени (в алфавитном порядке)");
        System.out.println("8 - Сортировка по цене (по убыванию)");
        System.out.println("9 - Выход");
        selection = InputNumber("Выберите критерий фильтрации: ");
        return selection;
    }

    public static int InputNumber(String Query) {
        System.out.print(Query);
        while (true) {
            if (iScanner.hasNextInt())
                return iScanner.nextInt();
            else {
                System.out.print(Query);
                iScanner.next();
            }
        }
    }

    public static Map<String, Integer> SortHashMap(Map<String, Integer> mapToSort) {
        Map<String, Integer> sortedMap = mapToSort.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        return sortedMap;
    }

    public static TreeMap<Integer, Laptop> GetNotebookList() {
        TreeMap<Integer, Laptop> notebooks = new TreeMap<>();
        Laptop nB1 = new Laptop("ASUS X515EA-BQ1185W", "ASUS", "Intel Core i5",
                8, 512, "Windows 11 Home", "Grey", 44400);
        Laptop nB2 = new Laptop("HUAWEI MateBook D 15", "HUAWEI", "AMD Ryzen 5",
                16, 512, "Windows 11 Home", "Grey", 56630);
        Laptop nB3 = new Laptop("Apple MacBook Air 13", "Apple", "Apple M2",
                8, 256, "macOS", "Grey space", 97416);
        Laptop nB4 = new Laptop("HONOR MagicBook 15", "HONOR", "AMD Ryzen 5",
                16, 512, null, "Grey space", 43974);
        Laptop nB5 = new Laptop("Lenovo IdeaPad 3", "Lenovo", "Intel Celeron N4020",
                8, 256, "Windows 11 Home", "Abyss blue", 30385);
        Laptop nB6 = new Laptop("MSI Modern 14 C12M-233XRU", "MSI", "Intel Core i3",
                8, 256, "DOS", "Black", 35000);
        Laptop nB7 = new Laptop("Acer Extensa 15", "ACER", "AMD Ryzen 5",
                8, 512, null, "Black", 42688);
        notebooks.put(1, nB1);
        notebooks.put(2, nB2);
        notebooks.put(3, nB3);
        notebooks.put(4, nB4);
        notebooks.put(5, nB5);
        notebooks.put(6, nB6);
        notebooks.put(7, nB7);
        return notebooks;
    }
}