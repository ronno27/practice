package org.example;

import java.nio.file.Path;
import java.util.List;

/*
    Зам по зрелищам Тита Флавия Веспасиана записывает результаты гладиаторских боев с животными в колизее в формате:
    + Дата;
    + имя гладиатора;
    + лудус, если есть - школа подготовки гладиатора;
    + животное-противник;
    + гладиатор победил;
    + гладиатор был помилован.

    Необходимо вывести следующую информацию:
    + Самое смертоносное животное;
    + Список гладиаторов не из лудуса, которые выжили не менееэ́ 3 раз, но затем погибли в битве так и получив помилование;
    + Лудус, который готовит лучших бойцов с животными.

    + В задаче должны использоваться элементы функционального программирования
    + Задача должна быть представлена в виде maven-проекта
    + Задача должна быть покрыта тестами с помощью JUnit

 */

public class ColiseumMain {
    private static final Path PATH = Path.of("module2/src/main/resources/fights.txt");

    public static void main(String[] args) {
        FileSupplier fileSupplier = new FileSupplier();
        List<Fight> fightsList = fileSupplier.readFightsListFromFile(PATH);
        ColiseumStatistics statistics = new ColiseumStatistics(fightsList);

         try {
             System.out.println("Самое смертоносное животное -> " + statistics.theMostMurderousAnimal());
         } catch (NullPointerException exception){
             System.out.println("Функция вернула NULL");
             throw new RuntimeException();
        }

        System.out.println("Список гладиаторов не из лудуса, которые выжили не менее 3 раз, " +
                "но затем погибли в битве, так и не получив помилование:\n"
                + statistics.gladiatorsListThatSurvivedThreeTimes());

        try {
            System.out.println("Лудус, который готовит лучших бойцов с животными -> " + statistics.theBestLudus());
        } catch (NullPointerException exception){
            System.out.println("Функция вернула NULL");
            throw new RuntimeException();
        }
    }
}