package Characters;

import java.util.Random;
import enums.*;
import interfaces.*;
import exception.*;
public class Carlson extends Character implements Flyable {
    private int propellerEnergy;
    private Mood mood;

    public Carlson(String name) {
        super(name);
        Random rand = new Random();
        this.propellerEnergy = rand.nextInt(101);  // энергия пропеллера от 0 до 100
        this.mood = rand.nextBoolean() ? Mood.GOOD : Mood.BAD;  // случайное настроение
    }

    @Override
    public void performAction() {
        System.out.println(name + " вздохнул!\nКарлсон подхватывает Малыша и готовится к полету.");
    }

    @Override
    public void fly() throws FlightException {
        System.out.println(name + " начинает полет.");
        if (propellerEnergy < 30) {
            throw new FlightException("Пропеллер Карлсона сломан, полет не состоялся.");
        }
    }

    public void performSharpTurn() {
        if (mood == Mood.GOOD) {
            System.out.println(name + " совершает резкий вираж!");
        }
    }

    public int getPropellerEnergy() {
        return propellerEnergy;
    }

    public Mood getMood() {
        return mood;
    }
}