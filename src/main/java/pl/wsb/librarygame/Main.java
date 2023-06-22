package pl.wsb.librarygame;

import pl.wsb.librarygame.model.User;
import pl.wsb.librarygame.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
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
    }

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

    public static void displayCreatorInfo() {
        System.out.println("------------------------------");
        System.out.println("Imię: Arkadiusz");
        System.out.println("Numer albumu: 24229");
        System.out.println("Grupa: C5 - niestacjonarne");
        System.out.println("------------------------------");
    }
}
