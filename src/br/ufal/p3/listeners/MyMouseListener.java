package br.ufal.p3.listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyMouseListener implements MouseListener {
	
	private JLabel image;
	private String filename;
	private String additionalFilename;
	
	public MyMouseListener(JLabel image, String filename, String additionalFilename) {
		this.image = image;
		this.filename = filename;
		this.additionalFilename = additionalFilename;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		image.setIcon(new ImageIcon("src/images/" + filename + additionalFilename + ".png"));
		image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		image.setIcon(new ImageIcon("src/images/" + filename + ".png"));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
