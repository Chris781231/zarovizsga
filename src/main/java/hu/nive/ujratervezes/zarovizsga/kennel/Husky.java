package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

    private int happiness = super.getHappiness();

    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        this.happiness += 4;
    }

    @Override
    public void play(int hours) {
        this.happiness += hours * 3;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }
}
