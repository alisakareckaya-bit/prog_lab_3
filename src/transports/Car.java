package transports;

public class Car extends ShortyCars {

    public Car() {
        super();
        this.type = "Машина";
        this.minFuel = 10;
        this.maxSpeed = 50;
        this.syrupLevel = Math.random() * 20;
    }

    public Car(String carName) {
        super(carName);
        this.type = "Машина";
        this.minFuel = 10;
        this.maxSpeed = 50;
        this.syrupLevel = Math.random() * 20;
    }

}