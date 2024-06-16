package Ranking;

import java.io.Serializable;

public class Player implements Serializable {

    public String name;
    public int points;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }
    @Override
    public String toString() {
        return "name: " + name+ "   points: " + points;
    }
}
