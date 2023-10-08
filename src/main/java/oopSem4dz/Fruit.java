package oopSem4dz;

public abstract class Fruit {

private final float wheight;
private final String name;

public Fruit(float wheight, String name){
this.wheight = wheight;
this.name = name;
}

    public float getWheight() {
        return wheight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s, вес %2f", name, wheight);
    }
}
