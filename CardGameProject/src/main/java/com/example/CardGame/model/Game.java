package com.example.CardGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private String gameId;
    private GameDeck gameDeck;
    private List<Player> players;

    public Game() {
        this.gameId = UUID.randomUUID().toString();
        this.gameDeck = new GameDeck();
        this.players = new ArrayList<Player>();
    }

    public Game(String gameId, GameDeck gameDeck, List<Player> players) {
        this.gameId = gameId;
        this.gameDeck = gameDeck;
        this.players = players;
    }

    public String getGameId() {
        return gameId;
    }

    public GameDeck getGameDeck() {
        return gameDeck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public void setGameDeck(GameDeck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
