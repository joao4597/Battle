package model;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author plima
 */
public class Ship {
    private boolean rotation = false, hover = false;
    private String name;
    private boolean vertical = false, position = false;
    private Color color;
    private int num;
    private Point[] points;

    /**
     * Classe do navio
     * @param name Nome do navio
     * @param num ID do navio
     * @param points Capacidade do navio
     */
    
    public Ship(String name, int num,Point[] points) {
        this.name = name;
        this.num = num;
        this.points = points;
    }

    public boolean isRotation() {
        return rotation;
    }

    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public  Color getcolor() {
        return color;
    }

    public  void setColor(Color cor) {
        this.color = cor;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }
    
    
}
