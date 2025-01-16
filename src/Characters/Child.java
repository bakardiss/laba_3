package Characters;

import java.util.Random;
import enums.*;

public class Child extends Character {
    private ComfortState comfortState;

    public Child(String name) {
        super(name);
        Random rand = new Random();
        this.comfortState = ComfortState.values()[rand.nextInt(ComfortState.values().length)];
    }

    @Override
    public void performAction() {
        if (comfortState == ComfortState.WORRIED) {
            System.out.println("Карслон вздохул!\nКарлсон подхватывает Малыша и готовиться к полёту,\nНо Малыш был обеспокоен и отказался полететь с Карлсоном!");
        }
    }

    public ComfortState getComfortState() {
        return comfortState;
    }
}