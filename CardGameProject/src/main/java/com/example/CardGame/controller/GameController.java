package com.example.CardGame.controller;

import com.example.CardGame.model.Card;
import com.example.CardGame.model.Player;
import com.example.CardGame.model.Suit;
import com.example.CardGame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/game")
public class GameController {

    private GameRepository gameRepository;
    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping(path = "/new")
    String createGame() {
        return gameRepository.createGame();
    }

    @GetMapping(path = "/deck/new")
    String createDeck(){
        return gameRepository.createDeck();
    }

    @GetMapping(path = "/players")
    List<Player> getListPlayers(String gameId) throws Exception {
        return gameRepository.getListOfPlayerWithTotalValue(gameId);
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


}
