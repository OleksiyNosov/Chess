package model;

public class Player {
    private int id;
    private int color;

    public Player(int color) {
        id = UniquePlayerId.newId();
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getColor() {
        return color;
    }
}
