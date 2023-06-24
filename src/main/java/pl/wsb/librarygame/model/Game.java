package pl.wsb.librarygame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Klasa reprezentująca grę.
 */
@Getter
@AllArgsConstructor
public class Game implements Serializable {
    private String name;
}