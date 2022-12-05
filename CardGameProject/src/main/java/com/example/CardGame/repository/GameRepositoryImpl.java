package com.example.CardGame.repository;

import com.example.CardGame.model.*;

import java.util.*;

public class GameRepositoryImpl implements GameRepository{

    private Map<String, Game> gameMap = new HashMap<>();
    private Map<String, Deck> deckMap = new HashMap<>();
    @Override
    public String createGame() {
        Game game = new Game();
        gameMap.put(game.getGameId(), game);
        return game.getGameId();
    }

    @Override
    public Optional<Game> getGame(String gameId) {
        return Optional.ofNullable(gameMap.get(gameId));
    }

    @Override
    public void deleteGame(String gameId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() ->new Exception("Game is not found"));
        this.gameMap.remove(game.getGameId());

    }

    @Override
    public String createDeck() {
        Deck deck = new Deck();
        deckMap.put(deck.getDeckId(), deck);
        return deck.getDeckId();
    }

    @Override
    public Optional<Deck> getDeck(String deckId) {
        return Optional.ofNullable(deckMap.get(deckId));
    }

    @Override
    public void addDeckToGameDeck(String gameId, String deckId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() -> new Exception("Game is not found."));
        Deck deck = this.getDeck(deckId).orElseThrow(() -> new Exception("Deck is not found."));
        game.getGameDeck().getCards().addAll(deck.getCards());
    }

    @Override
    public void addPlayer(String gameId, String playerId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() -> new Exception(("Game is not found.")));
        Optional<Player> player = game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId())).findAny();

        if(player.isPresent()) {
            throw new IllegalArgumentException("Cannot add player, player already exists.");
        } else {
            game.getPlayers().add(new Player(playerId));
        }
    }

    @Override
    public void removePlayer(String gameId, String playerId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() -> new Exception(("Game is not found.")));
        Player player = game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId()))
                                        .findAny().orElseThrow(() -> new Exception("player is not found"));
        game.getPlayers().remove(player);
    }

    @Override
    public void dealCards(String gameId, int cards) {
        //TODO : to be implemented
    }

    @Override
    public List<Card> getListOfCardsForAPlayer(String gameId, String playerId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() -> new Exception(("Game is not found.")));
        Player player = game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId()))
                            .findAny().orElseThrow(() -> new Exception("player is not found"));

        return player.getCards();
    }

    @Override
    public List<Player> getListOfPlayerWithTotalValue(String gameId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() -> new Exception(("Game is not found.")));
        List<Player> players = game.getPlayers();
        Collections.sort(players);
        return players;
    }

    @Override
    public Map<Suit, Integer> getCountOfUndealtCardsPerSuit(String gameId) throws Exception {
        Game game = this.getGame(gameId).orElseThrow(() -> new Exception(("Game is not found.")));
        Map<Suit, Integer> countPerSuit = new HashMap<>();
        for(Card card : game.getGameDeck().getCards()) {
            if(!countPerSuit.containsKey(card.getSuit())){
                countPerSuit.put(card.getSuit(), 1);
            } else {
                countPerSuit.put(card.getSuit(), countPerSuit.get(card.getSuit())+1);
            }
        }
        return countPerSuit;
    }

    @Override
    public Map<Card, Integer> getCountOfEachUndealtCard(String gameId) {
        return null;
    }

    @Override
    public void shuffle(String gameId) {

    }
}
