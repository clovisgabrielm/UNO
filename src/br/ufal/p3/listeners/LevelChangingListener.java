package br.ufal.p3.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import br.ufal.p3.uno.GameManager;

public class LevelChangingListener implements ActionListener {

	private GameManager gameManager = GameManager.createInstance();
	
	JComboBox<String> levelComboBox = new JComboBox<>();
	
	public LevelChangingListener(JComboBox<String> levelComboBox) {
		this.levelComboBox = levelComboBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gameManager.setLevel(levelComboBox.getSelectedItem().toString());
		
	}

}
