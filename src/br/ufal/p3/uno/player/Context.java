package br.ufal.p3.uno.player;

public class Context {

	private PlayerStrategy playerStrategy;
	
	public Context() {
		playerStrategy = null;
	}
	
	public void setPlayerStrategy(PlayerStrategy playerStrategy) {
		this.playerStrategy = playerStrategy;
	}
	
	public PlayerStrategy getPlayerStrategy() {
		return playerStrategy;
	}
	
	public void playStrategy() {
		playerStrategy.play();
	}
}
