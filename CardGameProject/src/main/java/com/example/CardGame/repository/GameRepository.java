package com.example.CardGame.repository;

import com.example.CardGame.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GameRepository {
    String createGame();
    Optional<Game> getGame(String gameId);
    void deleteGame(String gameId) throws Exception;

    String createDeck();
    Optional<Deck> getDeck(String deckId);
    void addDeckToGameDeck(String gameId, String deckId) throws Exception;
    void addPlayer(String gameId, String playerId) throws Exception;
    void removePlayer(String gameId, String playerId) throws Exception;
    void dealCards(String gameId, int cards);
    List<Card> getListOfCardsForAPlayer(String gameId, String playerId) throws Exception;

    //this list should be displayed in descending order by total value
    List<Player> getListOfPlayerWithTotalValue(String gameId) throws Exception;

    Map<Suit, Integer> getCountOfUndealtCardsPerSuit(String gameId) throws Exception;

    //sorted by suit and face value from high to low
    Map<Card, Integer> getCountOfEachUndealtCard(String gameId);

    void shuffle(String gameId);


}
