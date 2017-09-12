package br.ufal.p3.listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.ufal.p3.uno.Card;
import br.ufal.p3.uno.GameManager;
import br.ufal.p3.uno.UI.BoardGameFrame;
import br.ufal.p3.uno.player.EasyPlayerStrategy;
import br.ufal.p3.uno.player.PlayerStrategy;

public class CardMouseListener implements MouseListener {
	private JLabel cardLabel;
	private Card card;
	private BoardGameFrame boardGame;
	
	private GameManager gameManager;
	
	public CardMouseListener(JLabel cardLabel, Card card, BoardGameFrame boardGame) {
		this.cardLabel = cardLabel;
		this.card = card;
		this.boardGame = boardGame;
		
		gameManager = GameManager.createInstance();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		cardLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		boolean jogou = true;
		
		if (card.getColor().equals(GameManager.getTheTopCard().getColor()) || card.getValue().equals(GameManager.getTheTopCard().getValue())
				|| card.getValue().equals("+4")) {
			GameManager.addCardInTableDeck(card);
			cardLabel.setVisible(false);
			boardGame.remove(cardLabel);
			boardGame.setNewTableDeckCard(card);
		
		}
		else if (card.getValue().equals("wild")) {
			GameManager.addCardInTableDeck(card);
			cardLabel.setVisible(false);
			boardGame.remove(cardLabel);
			boardGame.setNewTableDeckCard(card);
			JOptionPane.showMessageDialog(boardGame, "Consertar o wild");
		}
		else {
			JOptionPane.showMessageDialog(boardGame, "Escolha uma carta válida!");
			jogou = false;
		}
		
		if(jogou) {
			for (PlayerStrategy player : gameManager.getPlayers()) {
				if(player instanceof EasyPlayerStrategy) {
					player.play();
					
					boardGame.updateBoardGameComponentsUI();
					
				}
			}
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
