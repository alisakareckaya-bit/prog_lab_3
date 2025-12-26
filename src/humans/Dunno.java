package humans;

import transports.*;

public class Dunno extends Shorties {
    protected boolean canDrive;
    public Dunno(String name, boolean haveDriverLicense, Level likeSoda) {
        super(name, haveDriverLicense, likeSoda);
        this.canDrive = Math.random() < 0.1;
    }

    public TheftAttempt stealCar(Toropyshka toro, ShortyCars[] cars) throws StoryException {
        System.out.println("\n" + getName() + " действует:");
        System.out.print("Торопыжка дома? ");
        if (toro.getStatus()) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }

        if (toro.getStatus()) {
            System.out.println("Торопыжка видит! Незнайка пойман и осужден!");
            throw new StoryException("Незнайка был пойман Торопыжкой в гараже!");
        }

        ShortyCars car = cars[(int)(Math.random() * cars.length)];
        System.out.println("Выбрал: " + car);
        System.out.println("Сиропа сейчас: " +
                String.format("%.1f", car.syrupLevel) + " л.");



        System.out.println("Незнайка забрался в автомобиль и стал дергать за рычаги и нажимать педали.");
        if (!this.canDrive) {
            System.out.println("Незнайка не умеет водить! Не может завести машину.");
            System.out.println("К сожалению, угон невозможен");
            return new TheftAttempt(this, car, this.isDriving());
        }
        System.out.println("Незнайка пытается завести...");

        car.refuelToRequired();
        if (this.rideCar(car)) {
            System.out.println("ПОЕХАЛИ!!!!!");
        }

        return new TheftAttempt(this, car, this.isDriving());
    }
}