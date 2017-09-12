package br.ufal.p3.uno.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import br.ufal.p3.observable.UNOPlayerObservable;
import br.ufal.p3.uno.Card;
import br.ufal.p3.uno.GameManager;

public abstract class PlayerStrategy implements Observer {
	private String name;
	private String score;
	private boolean screamedUno;
	private Observable unoPlayerObservable;
	protected List<Card> cards;
	
	public PlayerStrategy(String name) {
		cards = new ArrayList<>();
		this.name = name;
		screamedUno = false;
		unoPlayerObservable = new UNOPlayerObservable();
		unoPlayerObservable.addObserver(this);
	}
	
	abstract public void play();
	
	public String getName() {
		return name;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	protected boolean isAValidCard(Card card) {
		return (card.getValue() == GameManager.getTheTopCard().getValue()
				|| card.getColor() == GameManager.getTheTopCard().getColor());
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public int getAmountOfCards() {
		return cards.size();
	}
	
	protected Card getCardFromTheDeck() {
		Card newCard = GameManager.giveCard();
		cards.add(newCard);
		
		return newCard;
	}
	
	public abstract Card chooseACardToPlay(Card card);
	
	@Override
	public void update(Observable unoPlayerObservable, Object arg1) {
		if(unoPlayerObservable instanceof UNOPlayerObservable) {
			UNOPlayerObservable newUnoPlayer = (UNOPlayerObservable) unoPlayerObservable;
			
			PlayerStrategy unoPlayer = newUnoPlayer.getPlayer();
			
			// If the player was UNO and he didn't screamed it, he must get three cards from the deck
			
			if (!unoPlayer.screamedUno) {
				
				JOptionPane.showMessageDialog(null, name + " não gritou UNO! Então puxa três cartas.");
				
				for(int i = 0; i < 3; i++) {
					unoPlayer.getCardFromTheDeck();
				}
			}
		}
		
	}
}
