package pl.wsb.librarygame.model;

import lombok.Getter;

import java.io.Serializable;

/**
 * Klasa reprezentująca użytkownika.
 */
@Getter
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
}