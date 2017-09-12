package br.ufal.p3.uno.UI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {
	private Image backgroundImage;
	
	public JPanelWithBackground(String filename) throws IOException {
		backgroundImage = ImageIO.read(new File(filename));
	}
	
	public void setBackgroundImage(String filename) throws IOException {
		backgroundImage = ImageIO.read(new File(filename));
	}
	
	public Image getBackgroundImage() {
		return backgroundImage;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backgroundImage, 0, 0, this);
	}
}
