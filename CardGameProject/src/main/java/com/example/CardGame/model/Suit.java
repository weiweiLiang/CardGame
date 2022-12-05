package com.example.CardGame.model;

public enum Suit {
    HEART(1), SPADE(2), CLUB(3), DIAMOND(4);
    private int value;
    private Suit(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
