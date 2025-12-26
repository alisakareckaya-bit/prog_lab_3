package humans;

public class Toropyshka extends Shorties {
    private boolean isHome;

    public Toropyshka(String name, boolean haveDriverLicense, Level likeSoda) {
        super(name, haveDriverLicense, likeSoda);
    }

    public void changeRandomStateToro() {
        this.isHome = (Math.random() < 0.5);
        System.out.print(getName() + " теперь: ");
        if (isHome) {
            System.out.println("дома");
        } else {
            System.out.println("не дома");
        }
    }

    public boolean getStatus() {
        return isHome;
    }
}