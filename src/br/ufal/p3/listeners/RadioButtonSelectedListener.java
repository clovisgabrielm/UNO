package br.ufal.p3.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import br.ufal.p3.uno.GameManager;

public class RadioButtonSelectedListener implements ActionListener {
	
	private GameManager gameManager = GameManager.createInstance();
	private JRadioButton radioButton;
	
	public RadioButtonSelectedListener(JRadioButton radioButton) {
		this.radioButton = radioButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gameManager.setAmountOfPlayers(Integer.parseInt(radioButton.getText()));
	}

}
