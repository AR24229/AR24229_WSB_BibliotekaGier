package pl.wsb.librarygame.service;

import pl.wsb.librarygame.model.Game;
import pl.wsb.librarygame.model.Library;
import pl.wsb.librarygame.model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryService {
    public static void addUser(List<User> users, String nickname) {
        for (User user : users) {
            if (user.getNickname().equalsIgnoreCase(nickname)) {
                System.out.println("Podany nick użytkownika już istnieje. Proszę wybrać inny.");
                return;
            }
        }
        users.add(new User(nickname));
        System.out.println("Dodano nową bibliotekę dla użytkownika " + nickname + ".");
    }

    public static void displayUserLibrary(List<User> users, String nickname) {
        for (User user : users) {
            if (user.getNickname().equalsIgnoreCase(nickname)) {
                Library library = user.getLibrary();
                List<Game> games = library.getGames();
                if (games.isEmpty()) {
                    System.out.println("Biblioteka jest pusta. Pora kupić jakieś gry!");
                } else {
                    Collections.sort(games, Comparator.comparing(Game::getName));
                    for (int i = 0; i < games.size(); i++) {
                        System.out.println((i + 1) + ". " + games.get(i).getName());
                    }
                }
                return;
            }
        }
        System.out.println("Nie znaleziono użytkownika o podanym nicku.");
    }

    public static void addGameToUserLibrary(List<User> users, String nickname, String gameName) {
        for (User user : users) {
            if (user.getNickname().equalsIgnoreCase(nickname)) {
                Library library = user.getLibrary();
                if (library.containsGame(gameName)) {
                    System.out.println("Już masz tę grę. Chyba pora sprawdzić swoją bibliotekę!");
                } else {
                    library.addGame(new Game(gameName));
                    System.out.println("Dodano grę " + gameName + ".");
                }
                return;
            }
        }
        System.out.println("Nie znaleziono użytkownika o podanym nicku.");
    }
}
