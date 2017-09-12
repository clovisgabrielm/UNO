package br.ufal.p3.uno.player;

import javax.swing.JOptionPane;

import br.ufal.p3.uno.Card;
import br.ufal.p3.uno.GameManager;

/**
 * 
 * @author Gabriel
 *
 * This class implements the easy way to play uno.
 * 
 */
public class EasyPlayerStrategy extends PlayerStrategy {

	public EasyPlayerStrategy(String name) {
		super(name);
	}

	@Override
	public void play() {
		
		Card choosenCard = chooseACardToPlay(GameManager.getTheTopCard());
		
		if (choosenCard != null) {
			GameManager.addCardInTableDeck(choosenCard);
		
			cards.remove(choosenCard);
			System.out.println(this.getName() + " tem agora " + this.getAmountOfCards());
		} else {
			Card newCard = getCardFromTheDeck();
			
			//Last chance
			if (isAValidCard(newCard)) {
				GameManager.addCardInTableDeck(newCard);
			}
			else {
				cards.add(newCard);

				JOptionPane.showMessageDialog(null, getName() + " puxou uma carta.");
			}
		}
		
		
	}
	
	public Card chooseACardToPlay(Card topCard) {
		for (Card card : cards) {
			if (card.getValue() == topCard.getValue() ||
					card.getColor() == topCard.getColor()) {
				
				return card;
			}
		}
		
		return null;
	}
	
}
