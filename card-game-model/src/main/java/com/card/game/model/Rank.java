package com.card.game.model;

public enum Rank {

    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
    QUEEN(12), KING(13), ACE(1);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == 1) {
            return "As";
        }
        else if (value == 11) {
            return "Valet";
        }
        else if (value == 12) {
            return "Reine";
        }
        else if (value == 13) {
            return "Roi";
        }
        return Integer.toString(value);
    }
}
