package pl.wsb.librarygame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca bibliotekę gier.
 */
public class Library implements Serializable {
    private List<Game> games;

    /**
     * Konstruktor tworzący nową bibliotekę gier.
     */
    public Library() {
        this.games = new ArrayList<>();
    }

    /**
     * Metoda dodająca grę do biblioteki.
     *
     * @param game Obiekt gry do dodania.
     */
    public void addGame(Game game) {
        games.add(game);
    }

    /**
     * Metoda zwracająca listę gier w bibliotece.
     *
     * @return Lista gier w bibliotece.
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     * Metoda sprawdzająca, czy w bibliotece znajduje się gra o podanej nazwie.
     *
     * @param name Nazwa gry do sprawdzenia.
     * @return Wartość logiczna true, jeśli gra o podanej nazwie istnieje w bibliotece, w przeciwnym razie false.
     */
    public boolean containsGame(String name) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
