package roguelike;

import asciiPanel.AsciiPanel;

public class MainGUI extends AsciiPanel{
	public int topLeftX;
	public int topLeftY;
	private AsciiPanel panel;
	private Player player;
	private int width;
	private int height;
	
	public MainGUI(AsciiPanel a, Player p, int width, int height) {
		this.panel = a;
		this.player = p;
		this.width = width;
		this.height = height;
	}
	
	public void drawLine() {
		for(int i=0; i< this.width; i++) {
			panel.write('-', i, topLeftY + height);
		}
	}
	
	public void displayPlayerHealth() {
		panel.write("Player Health: " + Integer.toString(player.health), topLeftX, topLeftY);
	}
	
	public void refresh() {
		drawLine();
		displayPlayerHealth();
	}

}
