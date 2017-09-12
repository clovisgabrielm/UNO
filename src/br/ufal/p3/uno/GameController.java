package br.ufal.p3.uno;

 /**
  * 
  * @author Gabriel
  *
  * This class controls which player will play in each turn.
  *
  */

public class GameController {
	private GameManager gameManager;
	private int playerPosition;
	
	public GameController() {
		gameManager = GameManager.createInstance();
	}
	
	public void next() {
		gameManager.getPlayer(playerPosition).play();
		
		playerPosition = ++playerPosition % 3;
	}
	
	
	
	
}
