package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Fight {
    public LocalDate fightDate;
    public String gladiatorName;
    public Ludus ludus;
    public Animal animal;
    public boolean win;
    public boolean pardoned;

    public Fight(LocalDate fightDate, String gladiatorName, Ludus ludus, Animal animal, boolean win, boolean pardoned) {
        this.fightDate = fightDate;
        this.gladiatorName = gladiatorName;
        this.ludus = ludus;
        this.animal = animal;
        this.win = win;
        this.pardoned = pardoned;
    }

    public boolean compareAnimals(Animal animal) {
        if (animal == null) {
            return this.animal == null;
        } else {
            return this.animal == animal;
        }
    }

    public boolean compareLudus(Ludus ludus) {
        if (ludus == null) {
            return this.ludus == null;
        } else {
            return this.ludus == ludus;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fight fight)) return false;
        return win == fight.win && pardoned == fight.pardoned && Objects.equals(fightDate, fight.fightDate) && Objects.equals(gladiatorName, fight.gladiatorName) && ludus == fight.ludus && animal == fight.animal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fightDate, gladiatorName, ludus, animal, win, pardoned);
    }

    @Override
    public String toString() {
        return  fightDate + ";" +
                gladiatorName + ';' +
                ludus + ";" +
                animal + ";" +
                win + ";" +
                pardoned;
    }
}
