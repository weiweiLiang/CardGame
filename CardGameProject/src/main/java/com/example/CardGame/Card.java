package com.example.CardGame;

public class Card {
    private Suit suit;
    private int faceValue;

    public Card() {
        this.suit = Suit.HEART;
        this.faceValue = 1;
    }

    public Card(Suit suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", faceValue=" + faceValue +
                '}';
    }

    public enum Suit {
        HEART,
        SPADE,
        CLUB,
        DIAMOND;
    }
}
