package br.ufal.p3.uno.UI;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.ufal.p3.listeners.CloseListener;
import br.ufal.p3.uno.GameManager;

/**
 * 
 * @author Gabriel
 *
 * This class collects some information about how game will go on.
 *
 */
public class StartingFrame extends JFrame {

	private final int WIDTH = 1030;
	private final int HEIGHT = 530;
	private GameManager gameManager;
	private JPanelWithBackground backgroundImage;
	private GameInternalFrame gameInternalFrame;

	public StartingFrame() {
		super(" UNO - INICIAR JOGO ");
			
		gameManager = GameManager.createInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setResizable(false);

		setIconImage(new ImageIcon("src/images/iconUno.jpg").getImage());
		
	}
	
	public void setBackgroundImage(String filename) {
		try {
			backgroundImage = new JPanelWithBackground(filename);

			getContentPane().add(backgroundImage);
			
		} catch (IOException e) {};
	}

	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Jogo");
		menuBar.add(gameMenu);

		JMenuItem menuItem;

		menuItem = new JMenuItem("      Novo jogo", null);
		gameMenu.add(menuItem);

		menuItem = new JMenuItem("      Nível de dificuldade");
		gameMenu.add(menuItem);

		menuItem = new JMenuItem("      Quantidade de jogadores",
				new ImageIcon("src/images/playerIcon.png"));
		gameMenu.add(menuItem);

		JMenu aboutMenu = new JMenu("Ajuda");
		menuBar.add(aboutMenu);

		menuItem = new JMenuItem("      Exibir Ajuda");
		aboutMenu.add(menuItem);

		menuItem = new JMenuItem("      Sobre o projeto");
		aboutMenu.add(menuItem);

		JMenu quitMenu = new JMenu("Sair");
		menuBar.add(quitMenu);

		quitMenu.addActionListener(new CloseListener(this));
		this.setJMenuBar(menuBar);
	}

	public void createGameInternalFrame() throws PropertyVetoException {
		JDesktopPane desktop = new JDesktopPane();

		gameInternalFrame = new GameInternalFrame(this);
		gameInternalFrame.setVisible(true);
		gameInternalFrame.fillGameInternalFrame();
		
		desktop.add(gameInternalFrame);
		desktop.add(backgroundImage);
		
		setContentPane(desktop);
	}


	public GameInternalFrame getInternalFrame() {
		return gameInternalFrame;
	}

	public void showAskingNameDialog() {

		gameManager.setMainPlayerName(JOptionPane.showInputDialog(this,
				"Digite seu nome:", "Iniciar jogo",
				JOptionPane.INFORMATION_MESSAGE));
	}

	
}
