package Characters;
import interfaces.*;
public abstract class Character implements Actionable {
    protected String name;

    public Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character: " + name;
    }
}