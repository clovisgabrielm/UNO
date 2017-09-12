package br.ufal.p3.uno.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import br.ufal.p3.listeners.CardMouseListener;
import br.ufal.p3.listeners.MyMouseListener;
import br.ufal.p3.uno.Card;
import br.ufal.p3.uno.GameManager;

/**
 * 
 * @author Gabriel
 * 
 * This is the main UI class of the game.
 * The game occurs in this screen. 
 *
 */

public class BoardGameFrame extends JFrame {

	private GameManager gameManager = GameManager.createInstance();
	private JDesktopPane desktop = new JDesktopPane();
	private JPanel boardGameBackground;
	private JLabel cardOnBoardTable;
	private JLabel firstPlayer;
	private JLabel secondPlayer;
	private final int WIDTH = 1330;
	private final int HEIGHT = 720;
	private static int MAIN_PLAYER = 0;
	private static int FIRST_PLAYER = 1;
	private static int SECOND_PLAYER = 2;

	public BoardGameFrame(String title) {
		setTitle(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setIconImage(new ImageIcon("src/images/iconUno.jpg").getImage());

		desktop.setSize(WIDTH, HEIGHT);
		desktop.setVisible(true);

	}
	
	public void prepareGame() {
		// Creating and distributing cards to the players and to the decks
		gameManager.prepareToPlay();
	}
	
	public void showFirstPlayer() {
		// Painting the first player
		JPanel firstPlayerPanel = new JPanel();
		firstPlayer = new JLabel(new ImageIcon("src/images/players/Player01.png"));
		firstPlayer.setText(" " + gameManager.getPlayer(FIRST_PLAYER).getAmountOfCards() + "    ");
		firstPlayer.setToolTipText(gameManager.getPlayer(FIRST_PLAYER).getName());
		firstPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		firstPlayer.setForeground(Color.WHITE);
		
		firstPlayerPanel.setLayout(new BorderLayout());
		firstPlayerPanel.add(firstPlayer, BorderLayout.LINE_START);
		firstPlayerPanel.setOpaque(false);
		
		boardGameBackground.add(firstPlayerPanel, BorderLayout.LINE_START);
	}

	public void showSecondPlayer() {
		// Painting the fifth player
		JPanel secondPlayerPanel = new JPanel();
		secondPlayer = new JLabel();
		secondPlayer.setText("" + gameManager.getPlayer(SECOND_PLAYER).getAmountOfCards() + " ");
		secondPlayer.setToolTipText(gameManager.getPlayer(SECOND_PLAYER).getName());
		secondPlayer.setIcon(new ImageIcon("src/images/players/Player05.png"));
		secondPlayer.setForeground(Color.WHITE);
		secondPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		secondPlayer.setLayout(new BorderLayout());

		JLabel auxiliarLabel = new JLabel("                ");
		auxiliarLabel.setBackground(Color.BLACK);
		secondPlayerPanel.setLayout(new BorderLayout());
		secondPlayerPanel.setOpaque(false);
		secondPlayerPanel.add(auxiliarLabel, BorderLayout.WEST);
		secondPlayerPanel.add(secondPlayer, BorderLayout.EAST);
		
		boardGameBackground.add(secondPlayerPanel, BorderLayout.LINE_END);
	}

	public void showBoardGameComponents() {
		// Showing the pull deck
		JPanel pullDeckPanel = new JPanel();
		pullDeckPanel.setLayout(new BorderLayout());
		pullDeckPanel.setOpaque(false);
		
		JLabel pullDeck = new JLabel(new ImageIcon("src/images/unoPullDeck.png"));
		
		pullDeck.addMouseListener(new MyMouseListener(pullDeck, "unoPulLDeck", "_on"));
		pullDeck.setToolTipText("" + gameManager.getPullDeckCapacity() + " cartas");
		
		// Showing the table deck
		Card tableDeckCard = GameManager.getTheTopCard();
		cardOnBoardTable = new JLabel(new ImageIcon(showCard(tableDeckCard)));

		
		// Showing the clockwise image
		JLabel arrow = new JLabel(new ImageIcon("src/images/sentido.png"));

		
		pullDeckPanel.add(pullDeck, BorderLayout.LINE_START);
		pullDeckPanel.add(arrow, BorderLayout.CENTER);
		pullDeckPanel.add(cardOnBoardTable, BorderLayout.LINE_END);
		
		
		boardGameBackground.add(pullDeckPanel, BorderLayout.CENTER);
	}
	
	public void setNewTableDeckCard(Card card) {
		cardOnBoardTable.setIcon(new ImageIcon(showCard(card)));
	}

	public void showMainPlayer() {
		// Creating a place for the main player
		
		Font newFont = new Font("Comic Sans MS", Font.BOLD, 28);
		
		JPanel userSpacePanel = new JPanel();
		userSpacePanel.setLayout(new GridLayout(0, 10));
		userSpacePanel.setOpaque(false);
		
		TitledBorder title = new TitledBorder(gameManager.getPlayers().get(MAIN_PLAYER).getName().toUpperCase());
		title.setTitleFont(newFont);
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitleColor(Color.BLACK);
		
		userSpacePanel.setBorder(BorderFactory.createTitledBorder(title));
		
		showMainPlayerCards(userSpacePanel);
		
		boardGameBackground.add(userSpacePanel, BorderLayout.PAGE_END);
	}

	private void showMainPlayerCards(JPanel mainPlayerPanel) {
		for (Card card : gameManager.getPlayers().get(MAIN_PLAYER).getCards()) {
			JLabel newCard = new JLabel(new ImageIcon(showCard(card)));
			newCard.addMouseListener(new CardMouseListener(newCard, card, this));
			mainPlayerPanel.add(newCard);
		}
	}

	public void updateBoardGameComponentsUI() {
		firstPlayer.setText(" " + gameManager.getPlayer(FIRST_PLAYER).getAmountOfCards() + "    ");
		secondPlayer.setText("" + gameManager.getPlayer(SECOND_PLAYER).getAmountOfCards() + " ");
		
		Card tableDeckCard = GameManager.getTheTopCard();		
		setNewTableDeckCard(tableDeckCard);



	}
	
	private String showCard(Card card) {
		return "src/images/" + card.getColor() + "/" + card.getColor() 
				+ "_" + card.getValue() + ".png";
	}

	public void setBoardGameBackground(JPanelWithBackground boardGameBackground) {
		this.boardGameBackground = boardGameBackground;
		
		this.boardGameBackground.setLayout(new BorderLayout());
		this.boardGameBackground.setVisible(true);
		
		desktop.add(this.boardGameBackground);
		getContentPane().add(this.boardGameBackground);
	}
}
