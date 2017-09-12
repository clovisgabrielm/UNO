package br.ufal.p3.uno.UI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.ufal.p3.listeners.LevelChangingListener;
import br.ufal.p3.listeners.RadioButtonSelectedListener;
import br.ufal.p3.listeners.StartGameListener;
import br.ufal.p3.uno.GameManager;

/**
 * 
 * @author Gabriel
 *
 * It's a default internal frame which appears in the starting frame.
 */

public class GameInternalFrame extends JInternalFrame {
	
	private GameManager gameManager = GameManager.createInstance();
	private StartingFrame startingFrame;
	
	public GameInternalFrame(StartingFrame startingFrame) {
		this.startingFrame = startingFrame;
		
		setBackground(Color.WHITE);
		
		setClosable(true);
		
		setSize(450, 135);
		
		setResizable(false);
		
		setBorder(BorderFactory.createLineBorder(Color.gray));
		
		moveToFront();
		
		setLocation(300, 150);
		
		setTitle("Informações adicionais");
		
		setLayout(new FlowLayout());
	}
	
	// Filling the internal frame
	public void fillGameInternalFrame() {
		
		JPanel gameLevelPanel = new JPanel();
		
		gameLevelPanel.setBackground(Color.WHITE);
		gameLevelPanel.setSize(200, 200);
		gameLevelPanel.setBorder(BorderFactory
				.createTitledBorder("Nível de dificuldade"));

		// Options for a combo box
		String[] levels = { "Fácil", "Médio", "Difícil", "Extremamente difícil" };

		JComboBox<String> levelComboBox = new JComboBox<>(levels);
		levelComboBox
				.addActionListener(new LevelChangingListener(levelComboBox));
		levelComboBox.setSelectedIndex(0);
		levelComboBox.setEditable(false);
		levelComboBox.setVisible(true);

		gameLevelPanel.add(levelComboBox);
		
		// Amount of players
		JPanel amountOfPlayersPanel = new JPanel();

		amountOfPlayersPanel.setBackground(Color.WHITE);
		amountOfPlayersPanel.setSize(380, 100);
		amountOfPlayersPanel.setBorder(BorderFactory
				.createTitledBorder("Quantidade de jogadores"));

		// Options for a combo box
		JRadioButton threePlayers = new JRadioButton("3");
		
		threePlayers.addActionListener(new RadioButtonSelectedListener(threePlayers));
		
		gameManager.setAmountOfPlayers(Integer.parseInt(threePlayers.getText()));
		
		threePlayers.setSelected(true);
		threePlayers.setBackground(Color.WHITE);

		
		JRadioButton fourPlayers = new JRadioButton("4");
		
		fourPlayers.addActionListener(new RadioButtonSelectedListener(fourPlayers));
		fourPlayers.setBackground(Color.WHITE);
		

		JRadioButton fivePlayers = new JRadioButton("5");
		
		fivePlayers.addActionListener(new RadioButtonSelectedListener(fivePlayers));
		fivePlayers.setBackground(Color.WHITE);

		
		JRadioButton sixPlayers = new JRadioButton("6");
		
		sixPlayers.addActionListener(new RadioButtonSelectedListener(sixPlayers));
		sixPlayers.setBackground(Color.WHITE);

		ButtonGroup group = new ButtonGroup();
		group.add(threePlayers);
		group.add(fourPlayers);
		group.add(fivePlayers);
		group.add(sixPlayers);
		
		amountOfPlayersPanel.add(threePlayers);
		amountOfPlayersPanel.add(fourPlayers);
		amountOfPlayersPanel.add(fivePlayers);
		amountOfPlayersPanel.add(sixPlayers);

		// Cancel and OK buttons
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.WHITE);

		JButton confirmButtonOk = new JButton("OK");
		confirmButtonOk.addActionListener(new StartGameListener(startingFrame));
		
		JButton cancel = new JButton("Cancelar");

		buttons.add(confirmButtonOk);
		buttons.add(cancel);

		add(gameLevelPanel);
		add(amountOfPlayersPanel);
		add(buttons);
				
	}
}
