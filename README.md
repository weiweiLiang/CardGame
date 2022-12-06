# CardGame

Simple Card Game project by using REST API and spring boot. 


The service should be run in the localhost : http://localhost:8080/api/card-game 

Create a game: 
http://localhost:8080/api/card-game/new

Delete a game: 
http://localhost:8080/api/card-game/delete

Create a deck: 
http://localhost:8080/api/card-game/deck/new

Add a deck to a game deck: 
http://localhost:8080/api/card-game/{gameid}/deck/add/{deckid}

Add a player: 
http://localhost:8080/api/card-game/{gameid}/player/add/{playerid}

Remove a player: 
http://localhost:8080/api/card-game/player/delete

Deal cards: 
http://localhost:8080/api/card-game/deal

get the list of cards for a player: 
http://localhost:8080/api/card-game/player/cards

Get the list of players in a game along with the total value of his (her) cards: 
http://localhost:8080/api/card-game/players

Get the count of undealt cards per suit: 
http://localhost:8080/api/card-game/undealtSuit

Get the count of each undealt card:
http://localhost:8080/api/card-game/undealtCards

Shuffle deck:
http://localhost:8080/api/card-game/shuffle
