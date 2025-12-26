package transports;

public class Bus extends ShortyCars {

    public Bus( ) {
        super();
        this.type = "Автобус";
        this.minFuel = 15.0;
        this.maxSpeed = 30;
        this.syrupLevel = Math.random() * 20;
    }

    public Bus(String carName) {
        super(carName);
        this.type = "Автобус";
        this.minFuel = 15.0;
        this.maxSpeed = 30;
        this.syrupLevel = Math.random() * 20;
    }

}

