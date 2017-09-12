package br.ufal.p3.uno.UI;

import java.beans.PropertyVetoException;
import java.io.IOException;

import br.ufal.p3.uno.GameManager;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		StartingFrame startingFrame = new StartingFrame();
		
		startingFrame.setBackgroundImage("src/images/unoBackgroundGame.jpg");
		startingFrame.setVisible(true);
		startingFrame.createMenu();
		startingFrame.showAskingNameDialog();

		try {
			startingFrame.createGameInternalFrame();
		} catch (PropertyVetoException e) {}
	
		
	}
}
