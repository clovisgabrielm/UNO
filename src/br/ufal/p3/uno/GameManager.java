package br.ufal.p3.uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import br.ufal.p3.uno.player.Context;
import br.ufal.p3.uno.player.EasyPlayerStrategy;
import br.ufal.p3.uno.player.ExpertPlayerStrategy;
import br.ufal.p3.uno.player.MainPlayerStrategy;
import br.ufal.p3.uno.player.PlayerStrategy;

/**
 * 
 * @author Gabriel
 *
 * In this class there are all of the logical operations running. 
 * We have the main player name, a string containing the level of the current game, 
 * and two lists containing all the cards and all the players.
 * 
 */

public class GameManager {
	private static GameManager gameManager;
	private Context playerContext;
	private String level;
	private int amountOfPlayers;
	private String mainPlayerName;
	private List<PlayerStrategy> players;
	private List<Card> cards;
	
	//This is the deck where the players throw a card.
	private static Stack<Card> tableDeck;
	
	//This is the deck which has cards to be pulled.
	private static Stack<Card> deck;
	
	private GameManager() {
		playerContext = new Context();
		cards = new ArrayList<>();
		deck = new Stack<>();
		tableDeck = new Stack<>();
		players = new ArrayList<>();
		cards = new ArrayList<>();
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public void setMainPlayerName(String mainPlayerName) {
		this.mainPlayerName = mainPlayerName;
	}
	
	public int getPullDeckCapacity() {
		return deck.capacity();
	}
	
	public PlayerStrategy getPlayer(int playerPosition) {
		return players.get(playerPosition);
	}
	
	public void setAmountOfPlayers(int amountOfPlayers) {
		this.amountOfPlayers = amountOfPlayers;
	}
	
	public int getPlayersSize() {
		return players.size();
	}
		
	public static synchronized GameManager createInstance() {
		if (gameManager == null) {
			gameManager = new GameManager();
		}
		return gameManager;
	}
	
	// Adding method for players
	public void addPlayer(PlayerStrategy player) {
		players.add(player);
	}
	
	public static Card getTheTopCard() {
		return tableDeck.peek();
	}
	
	// This method returns the amount of players, not counting with the main player (user).
	
	public String getLevel() {
		return level;
	}
		
	// Distribute cards for players and the pull deck.
	public void prepareToPlay() {
		List<String> colorNames = new ArrayList<>();
		
		colorNames.add("vermelho");
		colorNames.add("verde");
		colorNames.add("azul");
		colorNames.add("amarelo");
		
		for (int j = 0; j < 2; j++) {
			for (String color : colorNames) {
				// 0 - 9
				for (int i = 0; i <= 9; i++) {
					cards.add(new Card("" + i, color));
				}
				
				//One time only
				if (j == 0) {
					// wild
					cards.add(new Card("wild", ""));
					
					// +4
					cards.add(new Card("+4", ""));
				}
				
				// +2
				cards.add(new Card("+2", color));
				
				// reverse
				cards.add(new Card("inverter", color));
				
				// skip
				cards.add(new Card("bloqueio", color));
			}
		}
		
		// Adding players to the players' list.
		addPlayer(new MainPlayerStrategy(mainPlayerName));
		
		for (int i = 1; i < amountOfPlayers; i++) {
			if(!getLevel().equals("Extremamente difícil")) {
				playerContext.setPlayerStrategy(new EasyPlayerStrategy("Jogador " + i));
			}
			else {
				playerContext.setPlayerStrategy(new ExpertPlayerStrategy("Jogador " + i));
			}
			
			addPlayer(playerContext.getPlayerStrategy());
		}
		
		/* Distributing cards */
		distributeCards();

		// Putting the first card on the table deck
		tableDeck.push(deck.pop());
		
	}
	
	private void distributeCards() {
		
		int randomNumber;
		int totalOfCards = cards.size(); 
		
		// Shuffling - filling the deck
		while (!cards.isEmpty()) {
			randomNumber = (int) ((11 + (Math.random()*373)) % totalOfCards);
			
			Card removingCard = cards.get(randomNumber);
			
			cards.remove(randomNumber);
			deck.push(removingCard);
						
			totalOfCards--;
		}
		
		for (PlayerStrategy player : players) {
			for (int i = 0; i < 7; i++) {
				player.addCard(deck.pop());
			}
		}

	}
		
	public static Card giveCard() {
		return deck.pop();
	}
	
	// Adding method for the table deck (it never will be needed to remove from this deck).
	public static void addCardInTableDeck(Card card) {
		tableDeck.push(card);
	}
	
	public String getMainPlayerName() {
		return mainPlayerName;
	}

	public List<PlayerStrategy> getPlayers() {
		return players;
	}
	
}
