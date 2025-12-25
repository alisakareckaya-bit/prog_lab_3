package transports;

import humans.*;

import java.util.Objects;

public abstract class ShortyCars implements Refuelable {
    protected String carName;
    protected Shorties driver;
    public boolean isDriving = false;
    protected int maxSpeed;
    protected int speed = 0;
    public double syrupLevel;
    protected double minFuel;
    protected String type;

    public ShortyCars() {
        this.carName = "Автоваз";
    }

    public ShortyCars(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return type + " " + carName;
    }

    @Override
    public void refuelToRequired() {
        double required = getRequiredAmount();
        if (required > 0) {
            syrupLevel += required;
            System.out.println("Коротышка доливает " +
                    String.format("%.1f", required) + " л. сиропа");
            System.out.println("Теперь: " + String.format("%.1f", syrupLevel) + " л.");
        }
    }

    @Override
    public double getRequiredAmount() {
        if (syrupLevel >= minFuel) {
            return 0;
        }
        return minFuel - syrupLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShortyCars other = (ShortyCars) obj;
        return carName.equals(other.carName) && type.equals(other.type) && driver.equals(other.driver)
                && (isDriving == other.isDriving) && (maxSpeed == other.maxSpeed) && (minFuel == other.minFuel)
                && (syrupLevel == other.syrupLevel) && (speed == other.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, type, driver, isDriving, maxSpeed, minFuel, syrupLevel, speed);
    }

    public void drinkSyrup(double amount) {
        if (syrupLevel <= 0) {
            System.out.println(getClass().getSimpleName() + ": сироп уже закончился!");
            return;
        }

        if (amount > syrupLevel) {
            amount = syrupLevel;
        }
        syrupLevel -= amount;
        if (syrupLevel == 0.0) {
            System.out.println(getClass().getSimpleName() + ": сироп закончился!");
        } else {
            System.out.println("Выпито " + String.format("%.1f", amount) +
                    " л. сироп. Осталось в " + getClass().getSimpleName() + ":" + String.format("%.1f", syrupLevel) + " л.");
        }
    }

    public boolean start(Shorties driver) {
        if (isDriving) {
            return false;
        }
        if (syrupLevel >= minFuel) {
            this.isDriving = true;
            speed = maxSpeed;
            this.syrupLevel -= this.minFuel;
            System.out.printf("%s успешно угнана и начала движение\n", this.carName);
            this.driver = driver;
        } else {
            System.out.printf("%s не может начать движение, не хватает сиропа\n", this.carName);
        }
        return this.isDriving;
    }

    public void stop() {
        this.speed = 0;
        System.out.printf("%s остановилась\n", this.carName);
    }

    public boolean getStatus() {
        return isDriving;
    }
}
