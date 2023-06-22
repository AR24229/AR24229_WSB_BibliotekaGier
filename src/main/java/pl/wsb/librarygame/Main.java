package pl.wsb.librarygame;

import pl.wsb.librarygame.model.User;
import pl.wsb.librarygame.service.LibraryService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Główna klasa programu zarządzającego biblioteką gier.
 */
public class Main {
    private static final String DATA_FILE = "users.ser";

    /**
     * Metoda główna programu.
     *
     * @param args Argumenty wiersza poleceń.
     */
    public static void main(String[] args) {
        List<User> users = loadUsers();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Pobranie znaku nowej linii po wczytaniu liczby

            switch (choice) {
                case 1:
                    System.out.println("Podaj nick użytkownika:");
                    String nickname = scanner.nextLine();
                    LibraryService.addUser(users, nickname);
                    break;
                case 2:
                    System.out.println("Podaj nick użytkownika, którego bibliotekę chcesz sprawdzić:");
                    String userNickname = scanner.nextLine();
                    LibraryService.displayUserLibrary(users, userNickname);
                    break;
                case 3:
                    System.out.println("Podaj nick użytkownika, do którego chcesz dodać grę:");
                    String userNicknameToAddGame = scanner.nextLine();
                    System.out.println("Podaj nazwę gry:");
                    String gameName = scanner.nextLine();
                    LibraryService.addGameToUserLibrary(users, userNicknameToAddGame, gameName);
                    break;
                case 4:
                    displayCreatorInfo();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Wybierz opcję od 1 do 5.");
            }
        }

        saveUsers(users);
    }

    /**
     * Wyświetla menu programu.
     */
    public static void displayMenu() {
        System.out.println("----------- MENU -----------");
        System.out.println("1. Dodaj nowego użytkownika");
        System.out.println("2. Sprawdź bibliotekę użytkownika");
        System.out.println("3. Dodaj grę do biblioteki");
        System.out.println("4. Informacje o twórcy");
        System.out.println("5. Wyjdź z programu");
        System.out.println("----------------------------");
        System.out.println("Wybierz opcję:");
    }

    /**
     * Wyświetla informacje o mnie.
     */
    public static void displayCreatorInfo() {
        System.out.println("------------------------------");
        System.out.println("Imię: Arkadiusz");
        System.out.println("Numer albumu: 24229");
        System.out.println("Grupa: C5 - niestacjonarne");
        System.out.println("------------------------------");
    }

    /**
     * Wczytuje listę użytkowników z pliku.
     * A tutaj to sprawdzxam czy ktoś to wgl czyta.
     * @return Lista użytkowników.
     */
    private static List<User> loadUsers() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (List<User>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Wczytywanie użytkowników nie powiodło się. Tworzenie nowej listy użytkowników.");
            return new ArrayList<>();
        }
    }

    /**
     * Zapisuje listę użytkowników do pliku.
     * Pozdrawiam ludzi co weszli na to repozytorium.
     * @param users Lista użytkowników.
     */
    private static void saveUsers(List<User> users) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println("Zapisywanie użytkowników nie powiodło się.");
        }
    }
}
