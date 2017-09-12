package br.ufal.p3.uno.player;

import br.ufal.p3.uno.Card;

/**
 * 
 * @author Gabriel
 * 
 * This class implements a smart way to play UNO.
 *
 */
public class ExpertPlayerStrategy extends PlayerStrategy {

	public ExpertPlayerStrategy(String name) {
		super(name);
	}

	@Override
	public void play() {
		// MUST BE WRITTEN
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
