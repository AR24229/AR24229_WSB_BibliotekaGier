package pl.wsb.librarygame.model;

import java.io.Serializable;

/**
 * Klasa reprezentująca użytkownika.
 */
public class User implements Serializable {
    private String nickname;
    private Library library;

    /**
     * Konstruktor tworzący nowego użytkownika o podanym nicku.
     *
     * @param nickname Nick użytkownika.
     */
    public User(String nickname) {
        this.nickname = nickname;
        this.library = new Library();
    }

    /**
     * Metoda zwracająca nick użytkownika.
     *
     * @return Nick użytkownika.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Metoda zwracająca bibliotekę użytkownika.
     *
     * @return Obiekt biblioteki użytkownika.
     */
    public Library getLibrary() {
        return library;
    }
}
