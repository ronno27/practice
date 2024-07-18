package org.example;

public enum Ludus {
    ROME("Rome"),
    VERONA("Verona"),
    SIENNA("Sienna"),
    POMPEII("Pompeii"),
    TURIN("Turin"),
    RAVENNA("Ravenna");
    private final String title;

    Ludus(String title) {
        this.title = title;
    }

    public static Ludus getByString(String title) {
        for (Ludus ludus : Ludus.values()) {
            if (title.equals("null")) {
                return null;
            }
            if (ludus.title.equals(title)) {
                return ludus;
            }
        }
        return null;
    }
}
