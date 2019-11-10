package com.card.game.model;

public enum Suit {

    CLUBS("trèfle"),
    DIAMONDS("carreau"),
    HEARTS("coeur"),
    SPADES("pique");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
