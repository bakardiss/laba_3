package Characters;
import java.util.Random;
import enums.*;
import interfaces.*;
import exception.*;
public class Carlson extends Character implements Flyable {
    private int propellerEnergy; // Энергия пропеллера
    private Mood mood; // Настроение Карлсона

    public Carlson(String name) {
        super(name);
        Random rand = new Random();
        this.propellerEnergy = rand.nextInt(101); // Энергия пропеллера от 0 до 100
        this.mood = rand.nextBoolean() ? Mood.GOOD : Mood.BAD; // Случайное настроение
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

    // Кража продуктов
    public void stealItems() {
        System.out.println("Карлсон проникает на кухню и крадет молоко, сахар и какао.");
        // Взаимодействие с объектом FrekkenBok
        FrekkenBok frekkenBok = new FrekkenBok();
        frekkenBok.itemsStolen();
    }

    // Доставка Малыша
    public void deliverChild() {
        System.out.println("Карлсон доставляет Малыша на крыльцо домика за трубой.");
    }

    // Новый метод: проверка погодных условий
    public void checkWeather(Weather weather) throws FlightException {
        if (weather == Weather.COLD) {
            throw new FlightException("Слишком холодно! Пропеллер Карлсона не работает.");
        } else if (weather == Weather.RAINY) {
            System.out.println(name + " летит, несмотря на дождь.");
        } else {
            System.out.println(name + " наслаждается солнечной погодой.");
        }
    }

    // Новый метод: поддразнить Фрекен Бок
    public void teaseFrekkenBok() {
        System.out.println(name + " жужжит моторчиком у окна кухни, чтобы позлить Фрекен Бок.");
    }

    // Новый метод: отправиться на балкончик
    public void flyToBalcony() {
        System.out.println(name + " летит с Малышом на балкончик.");
    }

    // Геттеры
    public int getPropellerEnergy() {
        return propellerEnergy;
    }

    public Mood getMood() {
        return mood;
    }

    // Переопределение equals(), hashCode(), toString()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carlson carlson = (Carlson) obj;
        return propellerEnergy == carlson.propellerEnergy && mood == carlson.mood && name.equals(carlson.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + propellerEnergy;
        result = 31 * result + (mood != null ? mood.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carlson{" +
                "name='" + name + '\'' +
                ", propellerEnergy=" + propellerEnergy +
                ", mood=" + mood +
                '}';
    }
}