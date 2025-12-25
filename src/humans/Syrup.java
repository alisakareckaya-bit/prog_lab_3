package humans;

import transports.*;

public class Syrup extends Shorties {

    public Syrup(String name, boolean haveDriverLicense, Level likeSoda) {
        super(name, haveDriverLicense, likeSoda);
    }

    public void drinkRandomCar(ShortyCars[] allCars) {

        int randomNumber = (int)(Math.random() * allCars.length);
        ShortyCars car = allCars[randomNumber];

        double how = Math.random() * 20;

        System.out.println(getName() + " пьёт из " +
                car.getCarName());

        car.drinkSyrup(how);
    }
}