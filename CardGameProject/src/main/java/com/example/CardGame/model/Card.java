package com.example.CardGame.model;

public class Card implements Comparable<Card> {
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

    @Override
    public int compareTo(Card anotherCard) {
        int compareFace = Integer.compare(this.getFaceValue().getValue(), anotherCard.getFaceValue().getValue());
        return compareFace != 0 ? compareFace
                : Integer.compare(this.getSuit().getValue(), anotherCard.getSuit().getValue());
    }
}
