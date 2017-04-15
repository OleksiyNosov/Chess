package model;

public class UniquePlayerId {

    private static int counter = 1;

    public static int newId() {
        return counter++;
    }
}
