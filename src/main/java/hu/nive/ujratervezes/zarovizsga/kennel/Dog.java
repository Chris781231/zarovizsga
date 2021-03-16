package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    private final String name;
    private static final int HAPPINESS = 0;

    protected Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return Dog.HAPPINESS;
    }

    public abstract void feed();

    public abstract void play(int hours);
}
