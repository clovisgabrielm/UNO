package br.ufal.p3.observable;

import java.util.Observable;

import br.ufal.p3.uno.GameManager;
import br.ufal.p3.uno.player.PlayerStrategy;

public class UNOPlayerObservable extends Observable {
	
	private PlayerStrategy player;
	private GameManager gameManager;
	
	public UNOPlayerObservable() {
		gameManager = GameManager.createInstance();
	}
	
	public void veryfyIfIsUno() {

		for (PlayerStrategy player : gameManager.getPlayers()) {
			if(isUno(player)) {
				this.player = player;
				
				setChanged();
				notifyObservers();
				break;
			}
		}
	}
	
	public PlayerStrategy getPlayer() {
		return player;
	}
	
	private boolean isUno(PlayerStrategy player) {
		return (player.getCards().size() == 1);
	}
}
