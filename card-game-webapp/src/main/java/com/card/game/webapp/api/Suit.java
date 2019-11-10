package com.card.game.webapp.api;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Suit {

    CLUBS("clubs"),
    DIAMONDS("diamonds"),
    HEARTS("hearts"),
    SPADES("spades");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
