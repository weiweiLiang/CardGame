package com.example.CardGame.repository;

import com.example.CardGame.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GameRepository {
    Game createGame();
    void deleteGame(String gameId) throws Exception;
    Deck createDeck();
    void addDeckToGameDeck(String gameId, String deckId) throws Exception;
    void addPlayer(String gameId, String playerId) throws Exception;
    void removePlayer(String gameId, String playerId) throws Exception;
    void dealCardsForAPlayer(String gameId, int numnerOfCards) throws Exception;
    List<Card> getListOfCardsForAPlayer(String gameId, String playerId) throws Exception;

    //this list should be displayed in descending order by total value
    List<Player> getListOfPlayerWithTotalValue(String gameId) throws Exception;

    Map<Suit, Integer> getCountOfUndealtCardsPerSuit(String gameId) throws Exception;

    //sorted by suit and face value from high to low
    Map<Card, Integer> getCountOfEachUndealtCard(String gameId) throws Exception;

    void shuffle(String gameId) throws Exception;

}
