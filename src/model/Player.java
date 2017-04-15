package model;

public class Player {
    private int id;

    public Player() {
        id = UniquePlayerId.newId();
    }

    public int getId() {
        return id;
    }
}
