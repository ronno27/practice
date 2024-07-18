package org.example;

public enum Animal {
    LION("Lion"),
    TIGER("Tiger"),
    BEAR("Bear"),
    LEOPARD("Leopard"),
    PANTHER("Panther"),
    BULL("Bull");
    private final String title;

    Animal(String title) {
        this.title = title;
    }

    public static Animal getByString(String title) {
        for (Animal animal : Animal.values()) {
            if (title.equals("null")) {
                return null;
            }
            if (animal.title.equals(title)) {
                return animal;
            }
        }
        return null;
    }
}
