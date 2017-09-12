package br.ufal.p3.uno;

/**
 * 
 * @author Gabriel
 *
 * This class has the structure of the UNO card. The card has the value and color attributes. 
 * Note that "value" and "color" attributes was instantiated as a String; it has a reason:
 * to make a card image instance easier (picture on the screen).
 */
public class Card {
	private String value;
	private String color;
	
	public Card(String value, String color) {
		this.value = value;
		this.color = color;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getColor() {
		return color;
	}
}
