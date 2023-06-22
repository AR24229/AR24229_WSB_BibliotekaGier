package pl.wsb.librarygame.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Game> games;

    public Library() {
        this.games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean containsGame(String name) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
