package com.example.CardGame.controller;

import com.example.CardGame.model.*;
import com.example.CardGame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/card-game")
public class GameController {

    private GameRepository gameRepository;
    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping(path = "/new")
    Game createGame() {
        return gameRepository.createGame();
    }

    @GetMapping(path = "/deck/new")
    Deck createDeck(){
        return gameRepository.createDeck();
    }

    @GetMapping(path = "/players")
    List<Player> getListPlayers(String gameId) throws Exception {
        return gameRepository.getListOfPlayerWithTotalValue(gameId);
    }

    @GetMapping(path = "/deal")
    void dealCards(String gameId, int numberOfCards) throws Exception {
        gameRepository.dealCardsForAPlayer(gameId, numberOfCards);
    }

    @GetMapping(path = "/player/cards")
    List<Card> getListOfCardsForAPlayer(String gameId, String playerId) throws Exception {
        return gameRepository.getListOfCardsForAPlayer(gameId, playerId);
    }

    @GetMapping(path = "/undealtSuit")
    Map<Suit, Integer> getCountOfUndealtCardsPerSuit(String gameId) throws Exception {
        return gameRepository.getCountOfUndealtCardsPerSuit(gameId);
    }

    @GetMapping(path = "/undealtCards")
    Map<Card, Integer> getCountOfEachUndealtCard(String gameId) throws Exception {
        return gameRepository.getCountOfEachUndealtCard(gameId);
    }

    @PostMapping(path = "/{gameid}/deck/add/{deckid}")
    void addDeck(@PathVariable("gameid") String gameId, @PathVariable("deckid") String deckId) throws Exception {
        gameRepository.addDeckToGameDeck(gameId, deckId);
    }

    @PostMapping(path = "/{gameid}/player/add/{playerid}")
    void addPlayer(@PathVariable("gameid") String gameId, @PathVariable("playerid") String playerId) throws Exception {
        gameRepository.addPlayer(gameId, playerId);
    }

    @PostMapping(path = "/{gameid}/shuffle")
    void shuffle(@PathVariable("gameid") String gameId) throws Exception {
        gameRepository.shuffle(gameId);
    }

    @DeleteMapping(path = "/delete")
    void deleteGame(String gameId) throws Exception {
        gameRepository.deleteGame(gameId);
    }

    @DeleteMapping(path = "/player/delete")
    void deletePlayer(String gameId, String playerId) throws Exception {
        gameRepository.removePlayer(gameId,playerId);
    }

}
