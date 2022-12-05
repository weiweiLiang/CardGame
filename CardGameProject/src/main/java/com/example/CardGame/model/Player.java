package com.example.CardGame.model;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {
    private String playerId;
    private List<Card> cards = new ArrayList<>();
    private int totalValue = 0;

    public Player(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotalValue() {
        return this.totalValue = cards.stream().mapToInt(card -> card.getFaceValue().getValue()).sum();
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(otherPlayer.getTotalValue(), this.getTotalValue());
    }
}
