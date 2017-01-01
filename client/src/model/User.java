package model;

/**
 *
 * @author plima
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int points;
    private int wins;
    private int losses;

    /**
     * Classe de utilizador do jogo
     * @param id ID do utilizador
     * @param username Username do utilizador
     * @param password Password do utilizador
     * @param points Pontos do utilizador
     * @param wins Vitórias do utilizador
     * @param losses Derrotas do utilizador
     */
    public User(int id, String username, String password, int points, int wins, int losses) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
