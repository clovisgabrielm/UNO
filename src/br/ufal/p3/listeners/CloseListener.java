package br.ufal.p3.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CloseListener implements ActionListener {
	
	private JFrame frame;
	
	public CloseListener(JFrame mainFrame) {
		this.frame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		frame.setVisible(false);
		System.out.println("Entr");
	}

}
