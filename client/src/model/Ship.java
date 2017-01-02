/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Point;

/**
 * Class que guarda Informaçao de cada navio
 * @author joao
 */
public class Ship {
    private boolean rotation = false, hover = false;
    private String name;
    private boolean vertical = false, position = false;
    private Color color;
    private int num;
    private Point[] points;

    /**
     * guarda informação do navio em variaveis privadas
     * @param name nome do navio
     * @param num tamanho
     * @param points pontos que ocupa
     */
    public Ship(String name, int num,Point[] points) {
        this.name = name;
        this.num = num;
        this.points = points;
    }

    /**
     * 
     * @return orientação do navio true se estiver na vertia, false caso contrario
     */
    public boolean isRotation() {
        return rotation;
    }

    /**
     * roda o navio
     * @param rotation true para rodar 
     */
    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    /**
     * retorna nome do navio
     * @return nome do navio
     */
    public String getName() {
        return name;
    }

    /**
     * dar novo nome a navio
     * @param name String com nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return true se está na vertical 
     */
    public boolean isVertical() {
        return vertical;
    }

    /**
     * põe navio na vertical
     * @param vertical se true poe navio na vertical
     */
    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    /**
     * 
     * @return cor do navio (Color)
     */
    public  Color getcolor() {
        return color;
    }

    /**
     * alterar cor do navio
     * @param cor cor que pretendemos (tipo Color)
     */
    public  void setColor(Color cor) {
        this.color = cor;
    }

    
    /**
     * obter tamanho do navio
     * @return int tamnho
     */
    public int getNum() {
        return num;
    }

    /**
     * alterar tamanho do navio
     * @param num tamanho inteiro
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * obter pontos que o navio ocupa
     * @return array com pontos que ocupa
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * dar posiçoes ao navio
     * @param points array com pontos a ocupar
     */
    public void setPoints(Point[] points) {
        this.points = points;
    }

    /**
     * 
     * @return true se o navio está posicionado false caso contrario
     */
    public boolean isPosition() {
        return position;
    }

    
    /**
     * guarda numa variavel local a informaçao de que o navio está em posiçao
     * @param position boolean true se foi posicionado false caso contrario
     */
    public void setPosition(boolean position) {
        this.position = position;
    }
    
    
}
