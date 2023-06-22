package pl.wsb.librarygame.model;

import java.io.Serializable;

/**
 * Klasa reprezentująca grę.
 */
public class Game implements Serializable {
    private String name;

    /**
     * Konstruktor tworzący obiekt gry.
     *
     * @param name Nazwa gry.
     */
    public Game(String name) {
        this.name = name;
    }

    /**
     * Metoda zwracająca nazwę gry.
     *
     * @return Nazwa gry.
     */
    public String getName() {
        return name;
    }
}
