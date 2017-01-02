/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joao
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int points;
    private int wins;
    private int losses;

    public User(int id, String username, String password, int points, int wins, int losses) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
    }

    /**
     * obter id do jogador
     * @return int com id 
     */
    public int getId() {
        return id;
    }

    /**
     * guarda numa variavel local o id do jogador
     * @param id id do jogador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * obter username do jogador
     * @return String com username
     */
    public String getUsername() {
        return username;
    }

    /**
     * guarda numa variavel local o username do Jogador
     * @param username String com o username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * obter password do jogador
     * @return String com password
     */
    public String getPassword() {
        return password;
    }

    /**
     * guarda password numa ariavel local
     * @param password String com a password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * obter pontos do jogador
     * @return integer pontos
     */
    public int getPoints() {
        return points;
    }

    /**
     * guarda pontos do jogador numa variavel local
     * @param points integer com pontos
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * obter numero de vitorias do jogador
     * @return integer vitorias
     */
    public int getWins() {
        return wins;
    }

    /**
     * guarda vitorias do jogador numa variavel local
     * @param wins integer vitorias
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * obter derrotas do jogador
     * @return integer derrotas
     */
    public int getLosses() {
        return losses;
    }

    /**
     * guarda numa variavel local as derrotas do jogador
     * @param losses Integer derrotas
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }
    
    
}
