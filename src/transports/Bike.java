package transports;

public class Bike extends ShortyCars {

    public Bike() {
        super();
        this.type = "Велосипед";
        this.minFuel = 5.0;
        this.maxSpeed = 10;
        this.syrupLevel = Math.random() * 20;
    }

    public Bike(String carName) {
        super(carName);
        this.type = "Велосипед";
        this.minFuel = 5.0;
        this.maxSpeed = 10;
        this.syrupLevel = Math.random() * 20;
    }


}