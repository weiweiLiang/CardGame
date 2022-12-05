package com.example.CardGame.controller;

import com.example.CardGame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

   // @Autowired
    private GameRepository gameRepository;

    @RequestMapping(value = "/game/new", method = RequestMethod.GET)
    String createGame() {
        return gameRepository.createGame();
    }

}
