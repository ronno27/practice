package org.example;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class ColiseumStatistics {
    private final List<String> names = new ArrayList<>();
    private final List<Fight> fights;

    public ColiseumStatistics(List<Fight> fights) {
        this.fights = fights;
        getNames();
    }

    public Animal theMostMurderousAnimal() {
        EnumMap<Animal, Long> animals = new EnumMap<>(Animal.class);

        for (Animal animal : Animal.values()) {
            animals.put(animal, 0L);
        }
        animals.keySet()
                .forEach(a -> {
                    long animalWins = fights == null ? 0 : fights.stream()
                                                                 .filter(f-> f.compareAnimals(a) && !f.win)
                                                                 .count();
                    animals.replace(a, animalWins);
                }
        );

        long maxWins = animals.values().stream().max(Long::compare).orElse(0L);
        if (maxWins > 0) {
            for (Animal animal : animals.keySet()) {
                if (animals.get(animal).equals(maxWins)) {
                    return animal;
                }
            }
        }
        return null;
    }

    public List<String> gladiatorsListThatSurvivedThreeTimes() {
        return names.stream().filter(name ->
                    fights.stream().filter(fight ->
                            Objects.equals(fight.gladiatorName, name) && fight.ludus == null
                                    && !fight.pardoned).count() > 3 // не учитывается, что он в итоге был убит
        ).toList();
    }

    public Ludus theBestLudus() {
        EnumMap<Ludus, Long> ludusList = new EnumMap<>(Ludus.class);

        for (Ludus ludus : Ludus.values()) {
            ludusList.put(ludus, 0L);
        }
        ludusList.keySet()
                .forEach(l -> {
                            long ludusWins = fights == null ? 0 : fights.stream()
                                                                        .filter(f-> f.compareLudus(l) && f.win)
                                                                        .count();
                            ludusList.replace(l, ludusWins);
                        }
                );

        long maxWins = ludusList.values().stream().max(Long::compare).orElse(0L);
        if (maxWins > 0) {
            for (Ludus ludus : ludusList.keySet()) {
                if (ludusList.get(ludus).equals(maxWins)) {
                    return ludus;
                }
            }

        }
        return null;
    }

    private void getNames() {
        fights.forEach(fight -> {
            if (!names.contains(fight.gladiatorName)) {
                names.add(fight.gladiatorName);
            }
        });
    }
}
