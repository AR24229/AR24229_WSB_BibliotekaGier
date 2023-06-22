package pl.wsb.librarygame.model;

public class User {
    private String nickname;
    private Library library;

    public User(String nickname) {
        this.nickname = nickname;
        this.library = new Library();
    }

    public String getNickname() {
        return nickname;
    }

    public Library getLibrary() {
        return library;
    }
}
