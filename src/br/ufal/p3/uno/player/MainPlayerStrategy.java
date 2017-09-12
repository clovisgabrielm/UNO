package br.ufal.p3.uno.player;

import java.util.Observable;

import br.ufal.p3.uno.Card;
import br.ufal.p3.uno.GameManager;

/**
 * 
 * @author Gabriel
 * 
 * This is the user class. 
 * 
 */
public class MainPlayerStrategy extends PlayerStrategy {
	
	private GameManager gameManager;
	
	public MainPlayerStrategy(String name) {
		super(name);
		
		gameManager = GameManager.createInstance();
	}

	@Override
	public void play() { 	
		
	}

	@Override
	public Card chooseACardToPlay(Card card) {
		Card newCard = card;
		cards.remove(card);
		return newCard;
	}
	
	@Override
	public void update(Observable unoPlayerObservable, Object arg1) {
		// Do not need to implement this function in the user player class.
	}
}
