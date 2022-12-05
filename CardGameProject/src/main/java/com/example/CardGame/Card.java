package com.example.CardGame;

public class Card {
    private Suit suit;
    private FaceValue faceValue;

    public Card() {
        this.suit = Suit.HEART;
        this.faceValue = FaceValue.ACE;
    }

    public Card(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setFaceValue(FaceValue faceValue) {
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
    public enum FaceValue {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private final int value;

        private FaceValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
