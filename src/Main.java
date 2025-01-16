import java.util.Random;

import Characters.Carlson;
import Characters.Child;
import enums.*;
import records.*;
import exception.*;
public class Main {

    public static void main(String[] args) {
        try {
            // Создаем персонажей
            Carlson carlson = new Carlson("Карлсон");
            Child child = new Child("Малыш");

            // Определяем погоду
            Random rand = new Random();
            Weather weather = Weather.values()[rand.nextInt(Weather.values().length)];

            // Создаем окружение
            Environment environment = new Environment(weather);
            Location location = environment.getLocations().get(rand.nextInt(environment.getLocations().size()));

            // Состояние пропеллера
            PropellerState propellerState = new PropellerState(carlson.getPropellerEnergy(), carlson.getPropellerEnergy() < 30);
            System.out.println("Состояние пропеллера Карлсона: " + propellerState);

            // Изменение настроения Карлсона
            MoodChange moodChange = new MoodChange(Mood.BAD, Mood.GOOD);
            System.out.println("Изменение настроения Карлсона: " + moodChange);

            // Состояние полета
            FlightDetails flightDetails = new FlightDetails(carlson, child, location, weather, false);
            System.out.println("Детали полета: " + flightDetails);

            // Эффект погоды
            WeatherEffect weatherEffect = new WeatherEffect(weather, weather == Weather.SUNNY && carlson.getMood() == Mood.GOOD ? "Карлсон совершил резкий вираж!" : "Карлсон полетел спокойно.");
            System.out.println("Эффект погоды на полет: " + weatherEffect);

            // Обновляем состояние полета
            flightDetails = new FlightDetails(carlson, child, location, weather, true);

            // Результат полета
            FlightOutcome flightOutcome = new FlightOutcome(child.getComfortState(), true);
            System.out.println("Результат полета: " + flightOutcome);
            System.out.println("\n");
            // Летят ли они?

            if (carlson.getPropellerEnergy() <= 30) {
                System.out.println("Карслон вздохнул!\nКарлсон подхватывает Малыша и готовится к полёту.\nКарслон начинает полёт!\nПропеллер Карлсона оказался сломан, полёт не состоялся.");
                return;
            }

            if (weather == Weather.COLD) {
                System.out.println("Карслон вздохнул!\nОн хотел подхватить Малыша и улететь вместе с ним,\nНо на улице было так холодно, что Карлсон передумал совершать полёт!");
                return;
            }

            if (weather == Weather.RAINY) {
                System.out.println("Карслон вздохнул!\nКарлсон вглянул в окошко\nИ увидел, что на улице шёл сильный дождь,\nПоэтому предложил Малышу поиграть в настольные игры дома!");
                return;
            }

            if (weather == Weather.SUNNY) {
                System.out.println("Карслон вздохнул!\nПогода на улице была змечательная,\nПоэтому Карлсон подхватил Малыша и приготовился к полёту!");
                if (carlson.getMood() == Mood.GOOD) {
                    System.out.println("Карлсон совершает резкий вираж!\nУ Малыша загудело в ушах и засосало под ложечкой ещё сильнее!");
                }
                System.out.println("Они полетели на " + location.name());
                if (child.getComfortState() == ComfortState.SCARED) {
                    System.out.println("Малыш испугался, ему очень не понравился полёт!");
                }
                if (child.getComfortState() == ComfortState.CALM) {
                    System.out.println("Малыш был спокоен, ему очень понравился полёт!\nЗатем все произошло точь-в-точь так, как сказал Карлсон.");
                }
                return;
            }

            if (child.getComfortState() == ComfortState.WORRIED) {
                System.out.println("Карслон вздохнул!\nКарлсон подхватывает Малыша и готовиться к полёту,\nНо Малыш был обеспокоен и отказался полететь с Карлсоном!");
                return;
            }

            // Полет
            carlson.performAction();
            carlson.fly();  // Попытка взлететь



        } catch (FlightException e) {
            System.out.println(e.getMessage());
        }
    }
}