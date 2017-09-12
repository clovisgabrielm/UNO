package br.ufal.p3.listeners;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.Action;

import br.ufal.p3.uno.UI.BoardGameFrame;
import br.ufal.p3.uno.UI.JPanelWithBackground;
import br.ufal.p3.uno.UI.StartingFrame;

public class StartGameListener implements Action {
	private StartingFrame mainFrame;

	public StartGameListener(StartingFrame mainFrame) {
		this.mainFrame = mainFrame;		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainFrame.getInternalFrame().dispose();
		mainFrame.dispose();
		
		// Building the board game
		
		BoardGameFrame boardGameFrame = new BoardGameFrame("J O G O  U N O");
		
		boardGameFrame.setVisible(true);
		
		try {
			boardGameFrame.setBoardGameBackground(new JPanelWithBackground("src/images/boardGameBackground.jpg"));
		} catch (IOException e) {}
			
		
		boardGameFrame.prepareGame();
		
		boardGameFrame.showBoardGameComponents();
		
		boardGameFrame.showFirstPlayer();
		
		boardGameFrame.showSecondPlayer();
		
		boardGameFrame.showMainPlayer();
		
		boardGameFrame.setVisible(true);
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean arg0) {
		// TODO Auto-generated method stub

	}

}
