package humans;

import transports.ShortyCars;

import java.util.Objects;

public class Shorties{
    protected Level likeSoda;
    protected boolean haveDriverLicense;
    protected String name;
    protected ShortyCars car;

    public Shorties(String name, boolean haveDriverLicense, Level likeSoda) {
        this.name = name;
        this.haveDriverLicense = haveDriverLicense;
        this.likeSoda = likeSoda;
    }
    public void printSodaInfo() {
        System.out.println(name + " " + likeSoda.description);
    }
    public String getName() {
        return name;
    }

    public boolean rideCar(ShortyCars car) {
        if (this.car != null) { return false; }
        if (car.start(this)) {
            this.car = car;
        } else { return false; }
        return true;
    }

    public void leaveCar() {
        if (this.car != null) {
            this.car.stop();
            this.car = null;
        }
    }

    public boolean isDriving() {
        return this.car != null;
    }

    @Override
    public String toString() {
        return String.format("Коротышка %s", name);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shorties other = (Shorties) obj;
        return name.equals(other.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(likeSoda, haveDriverLicense, name);
    }

}