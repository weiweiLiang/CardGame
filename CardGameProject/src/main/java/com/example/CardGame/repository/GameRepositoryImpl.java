package com.example.CardGame.repository;

import com.example.CardGame.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameRepositoryImpl implements GameRepository{

    private Map<String, Game> gameMap = new HashMap<>();
    private Map<String, Deck> deckMap = new HashMap<>();
    @Override
    public String createGame() {
        Game game = new Game();
        gameMap.put(game.getGameId(), game);
        //TODO: remove this output
        System.out.println("create game.");
        return game.getGameId();
    }

    @Override
    public void deleteGame(String gameId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        this.gameMap.remove(game.getGameId());
        //TODO: remove this output
        System.out.println("Game deleted.");

    }

    @Override
    public String createDeck() {
        Deck deck = new Deck();
        deckMap.put(deck.getDeckId(), deck);
        //TODO: remove this output
        System.out.println("create deck.");
        return deck.getDeckId();
    }

    @Override
    public void addDeckToGameDeck(String gameId, String deckId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        Deck deck = Optional.ofNullable(deckMap.get(deckId)).orElseThrow(() -> new Exception("Deck is not found."));
        game.getGameDeck().getCards().addAll(deck.getCards());
        //TODO: remove this output
        System.out.println("Deck is added to game deck.");
    }

    @Override
    public void addPlayer(String gameId, String playerId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        Optional<Player> player = game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId())).findAny();

        if(player.isPresent()) {
            throw new IllegalArgumentException("Cannot add player, player already exists.");
        } else {
            game.getPlayers().add(new Player(playerId));
        }
        //TODO: remove this output
        System.out.println("Player added.");
    }

    @Override
    public void removePlayer(String gameId, String playerId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        Player player = game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId()))
                                        .findAny().orElseThrow(() -> new Exception("player is not found"));
        game.getPlayers().remove(player);
    }

    @Override
    public void dealCardsForAPlayer(String gameId, int numberOfCards) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        if(numberOfCards <= 0){
            throw new Exception("There is not card left to deal.");
        }
        //TODO : to be implemented

    }

    @Override
    public List<Card> getListOfCardsForAPlayer(String gameId, String playerId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        Player player = game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId()))
                            .findAny().orElseThrow(() -> new Exception("player is not found"));

        //TODO: to remove
        System.out.println("list of cards");
        return player.getCards();
    }

    @Override
    public List<Player> getListOfPlayerWithTotalValue(String gameId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        List<Player> players = game.getPlayers();
        //sort the list in descending order (default order)
        Collections.sort(players);
        //TODO: to remove
        System.out.println("list of players");
        return players;
    }

    @Override
    public Map<Suit, Integer> getCountOfUndealtCardsPerSuit(String gameId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        Map<Suit, Integer> countPerSuit = new HashMap<>();
        for(Card card : game.getGameDeck().getCards()) {
            if(!countPerSuit.containsKey(card.getSuit())){
                countPerSuit.put(card.getSuit(), 1);
            } else {
                countPerSuit.put(card.getSuit(), countPerSuit.get(card.getSuit())+1);
            }
        }
        //TODO: to remove
        System.out.println("count per suit");
        return countPerSuit;
    }

    @Override
    public Map<Card, Integer> getCountOfEachUndealtCard(String gameId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        Map<Card, Integer> countOfCard = new HashMap<>();
        for(Card card : game.getGameDeck().getCards()){
            if(!countOfCard.containsKey(card)){
                countOfCard.put(card, 1);
            }else {
                countOfCard.put(card, countOfCard.get(card)+1);
            }
        }
        Map<Card, Integer> sortedMap = new TreeMap<>(countOfCard);
        //TODO: to remove
        System.out.println("count of undealt card");
        return sortedMap;
    }

    @Override
    public void shuffle(String gameId) throws Exception {
        Game game = Optional.ofNullable(gameMap.get(gameId)).orElseThrow(() ->new Exception("Game is not found"));
        int deckSize = game.getGameDeck().getCards().size();
        Random random = new Random();
        for (int i = 0; i < deckSize; i++){
            int index =  i + random.nextInt(deckSize - i);
            Card cardToBeReplaced = game.getGameDeck().getCards().get(i);
            Card cardToReplace = game.getGameDeck().getCards().get(index);

            game.getGameDeck().getCards().set(i, cardToReplace);
            game.getGameDeck().getCards().set(index, cardToBeReplaced);
            //TODO: to remove
            System.out.println("Shuffled.");
        }
    }

    private boolean canDealCards(Game game){
        if(!game.getGameDeck().getCards().empty() && game.getGameDeck().getCards() != null){
            return true;
        }
        System.out.println("There is no card in the deck, cannot deal card.");
        return false;
    }
    private Optional<Card> getCardToDeal(Game game){
        return game.getGameDeck().getCards().isEmpty() ?
                Optional.empty() : Optional.of(game.getGameDeck().getCards().pop());
    }
}
