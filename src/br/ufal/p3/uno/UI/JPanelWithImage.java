package br.ufal.p3.uno.UI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelWithImage extends JPanel {
	private Image image;
	int x;
	int y;
	
	JPanelWithImage(String filename, int x, int y) throws IOException {
		image = ImageIO.read(new File(filename));
		this.x = x;
		this.y = y;
		this.setLocation(x, y);
	}
	
	public void setBackgroundImage(String filename) throws IOException {
		image = ImageIO.read(new File(filename));
	}
	
	public Image getImage() {
		return image;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image, x, y, this);
	}
}
