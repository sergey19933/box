import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Box implements InterfaceBox {
    private static List<Sweets> sweets = new ArrayList<>();

    /*
метод добавляет сладости в коробку
     */
    @Override
    public void addSweets() throws IOException {

        boolean finishChoice = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите цифру, чтобы добавить сладость в коробку:");
        System.out.println("1 - конфеты Сникерс");
        System.out.println("2 - конфеты Баунти");
        System.out.println("3 - торт Чародейка");
        System.out.println("4 - торт Прага");
        System.out.println("5 - пироженное Картошка");
        System.out.println("6 - пироженное Мечта");
        System.out.println("7 - закончить выбор");
        while (!finishChoice) {

            String addSweets = reader.readLine();

            switch (addSweets) {
                case "1":
                    Candy candy1 = new Candy("Конфеты Сникерс", 55, 30, "Тянется карамель");
                    sweets.add(candy1);
                    System.out.println("Конфеты Сникерс добавлены в коробку");
                    break;
                case "2":
                    Candy candy2 = new Candy("Конфеты Баунти", 40, 25, "Райское наслаждение");
                    sweets.add(candy2);
                    System.out.println("Конфеты Баунти добавлены в коробку");
                    break;
                case "3":
                    Cake cake1 = new Cake("Торт Чародейка", 800, 300, "Вкусный крем");
                    sweets.add(cake1);
                    System.out.println("Торт Чародейка добавлен в коробку");
                    break;
                case "4":
                    Cake cake2 = new Cake("Торт Прага", 500, 250, "Шоколадный");
                    sweets.add(cake2);
                    System.out.println("Торт Прага добавлен в коробку");
                    break;
                case "5":
                    Pastry pastry1 = new Pastry("Пироженное Картошка", 150, 100, "Очень сладкое");
                    sweets.add(pastry1);
                    System.out.println("Пироженное Картошка добавлено в коробку");
                    break;
                case "6":
                    Pastry pastry2 = new Pastry("Пироженное Мечта", 100, 50, "Очень нежное");
                    sweets.add(pastry2);
                    System.out.println("Пироженное Мечта добавлено в коробку");
                    break;
                case "7":
                    finishChoice = true;
                    break;
                default:
                    System.out.println("Такого нет, выберите из списка");
            }

        }
    }

    @Override
    public void totalPrice() {  //метод считает общую сумму коробки
        int totalPrice = 0;
        for (int i = 0; i < sweets.size(); i++) {
            totalPrice = totalPrice + sweets.get(i).getPrice();
        }
        System.out.println("Цена коробки: " + totalPrice + " руб");
    }

    @Override
    public void totalWeight() {  //метод считает общий вес коробки
        int totalWeight = 0;
        for (int i = 0; i < sweets.size(); i++) {
            totalWeight = totalWeight + sweets.get(i).getWeight();
        }
        System.out.println("Вес коробки: " + totalWeight + " гр");
    }

    /*
удаление сладостей
     */
    @Override
    public void removeSweets() throws IOException {
        System.out.println("Хотите ли убрать какие нибудь сладости из коробки?");
        System.out.println("Введите Yes или No");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String yesNo = reader.readLine();


        boolean finishRemove = false;
        while (!finishRemove) {
            if (yesNo.equalsIgnoreCase("Yes")) {
                System.out.println("Введите номер сладости");
                int number = Integer.parseInt(reader.readLine());
                sweets.remove(number);
                System.out.println("Удалить еще?: Yes/No");
                yesNo = reader.readLine();
            } else {
                finishRemove = true;
            }
        }
    }



    //удаление сладостей по меньшему весу из коробки
    public void removalByWeight() throws IOException {
        System.out.println("Введите входной параметр, вес в граммах: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(reader.readLine());
        sweets.sort(new Comparator<Sweets>() {  //сортировка листа по весу
            @Override
            public int compare(Sweets o1, Sweets o2) {
                if (o1.getWeight() == o2.getWeight()) return 0;
                else if (o1.getWeight() > o2.getWeight()) return 1;
                else return -1;
            }
        });


        boolean finishRemove = false;
        while (!finishRemove) {
            int totalWeight = 0;
            for (int i = 0; i < sweets.size(); i++) {
                totalWeight = totalWeight + sweets.get(i).getWeight();
            }
            if (weight <= totalWeight) {
                sweets.remove(0);
            } else
                finishRemove = true;
        }
    }

    //удаление сладостей по меньшей цене из коробки
    public void removalByPrice() throws IOException {
        System.out.println("Введите входной параметр, вес в граммах: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(reader.readLine());
        sweets.sort(new Comparator<Sweets>() {  //сортировка листа по весу
            @Override
            public int compare(Sweets o1, Sweets o2) {
                if (o1.getPrice() == o2.getPrice()) return 0;
                else if (o1.getPrice() > o2.getPrice()) return 1;
                else return -1;
            }
        });

        boolean finishRemove = false;
        while (!finishRemove) {
            int totalWeight = 0;
            for (int i = 0; i < sweets.size(); i++) {
                totalWeight = totalWeight + sweets.get(i).getWeight();
            }
            if (weight <= totalWeight) {
                sweets.remove(0);
            } else
                finishRemove = true;
        }
    }



    public void smartOptimization() throws IOException {
        System.out.println("Выбрать оптимизацию: ");
        System.out.println("1 - оптимизация по весу");
        System.out.println("2 - оптимизация по цене");
        System.out.println("3 - отмена");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String addSweets = reader.readLine();

        switch (addSweets) {
            case "1":
removalByWeight();
                break;
            case "2":
removalByPrice();
                break;
            case "3":
                System.out.println("Не использовать оптимизацию");
                break;
            default:
                System.out.println("Ошибка");

        }

    }




    /*
информация по всем сладостям в коробке
     */
    @Override
    public void info() {
        System.out.println("В коробке лежит:");
        int count = 0;
        for (Sweets sweets : sweets) {
            count++;
            System.out.println(count + ". " + sweets.getName() + " - " + sweets.getUniqueParameter());
        }
    }

    
    public static void main(String[] args) throws IOException {
        Box box = new Box();
        box.addSweets();
        box.removeSweets();
        box.smartOptimization();
        box.info();
        box.totalPrice();
        box.totalWeight();

    }

}
