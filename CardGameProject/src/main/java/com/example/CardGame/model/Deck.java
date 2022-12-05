package com.example.CardGame.model;

import java.util.Stack;
import java.util.UUID;

public class Deck {

    private String deckId;

    private Stack<Card> cards;

    public Deck() {
        this.deckId = UUID.randomUUID().toString();
        this.cards = createCards();
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    private Stack<Card> createCards() {
        Stack<Card> cards = new Stack<Card>();
        for(Suit suit : Suit.values()) {
            for (FaceValue face : FaceValue.values()) {
                cards.push(new Card(suit, face));
            }
        }
        return cards;
    }
}
