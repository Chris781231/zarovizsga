package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    private int happiness = super.getHappiness();

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        this.happiness += 2;
    }

    @Override
    public void play(int hours) {
        this.happiness += hours * 2;
    }

    @Override
    public int getHappiness() {
        return happiness;
    }
}
