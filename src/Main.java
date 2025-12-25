import humans.*;
import transports.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Начало истории ===\n");
        ShortyCars[] garage = {
                new Car("Lexus"),
                new Bus("Toyuta"),
                new Bike("BMW"),
                new Car("Мерседес"),
                new Car()
        };

        Syrup syrup = new Syrup("Сиропчик", true, Level.HIGH);
        Toropyshka toro = new Toropyshka("Торопыжка", true, Level.SMALL);
        Dunno dunno = new Dunno("Незнайка", true, Level.MEDIUM);

        System.out.println("Персонажи:");
        syrup.printSodaInfo();
        toro.printSodaInfo();
        dunno.printSodaInfo();

        System.out.println("В гараже:");
        for (ShortyCars car : garage) {
            System.out.println("- " + car +
                    ": " + String.format("%.1f", car.syrupLevel) + " л. сиропа");
        }

        System.out.println("\n--- Сиропчик в действии ---");
        syrup.drinkRandomCar(garage);

        System.out.println("\n--- Незнайка пытается угнать ---");

        ArrayList<TheftAttempt> attempts = new ArrayList<>();
        while (!dunno.isDriving()) {
            try {
                toro.changeRandomStateToro();
                System.out.print("\nТоропыжка: ");
                if (toro.getStatus()) {
                    System.out.println("Дома");
                    break;
                } else {
                    System.out.println("Не дома");
                }
                attempts.add(dunno.stealCar(toro, garage));
            } catch (StoryException e) {
                System.out.println("ООО НЕЕТ!!!: " + e.getMessage());
            }
        }

        System.out.println("\n=== Финальное состояние ===");
        for (ShortyCars car : garage) {
            String stat;
            if (car.isDriving) {
                stat = "угнан";
            } else {
                stat = "на месте";
            }

            System.out.println(car.getCarName() +
                    ": " + String.format("%.1f", car.syrupLevel) +
                    " л., статус: " + stat);
        }
    }
}