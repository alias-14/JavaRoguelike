package roguelike;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

public class ApplicationMain extends JFrame{
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private CreatureGenerator generate;
    private KeyHandler mainKeyListener;
    private Creature Player;
    private Level currentLevel;
    
    public static final int TERMINAL_WIDTH = 100;
    public static final int TERMINAL_HEIGHT = 50;
    
    public ApplicationMain() {
	    //super();
	    terminal = new AsciiPanel(TERMINAL_WIDTH,TERMINAL_HEIGHT,AsciiFont.TALRYTH_15_15);
	    LevelGenerator l = new LevelGenerator(100, 100, terminal);
	    Level currentLevel = l.generateLevel(1);
//	    currentLevel.drawLevel(terminal);
	    this.currentLevel = currentLevel;
	    
	    
	    generate = new CreatureGenerator(terminal, currentLevel);
	    //terminal.write("Roguelike", 1, 1);
	    
	    Player = generate.newPlayer();
	    Player.setCamera();
	    Player.camera.setDimensions(TERMINAL_WIDTH, TERMINAL_HEIGHT, 0, 10);
	    Player.camera.renderCamera();
	    
	    
	    mainKeyListener = new KeyHandler(Player, this);
	    addKeyListener(mainKeyListener);
	    
	    
	    
	    System.out.println("Completed task 1");
    	add(terminal);
    	pack();
    	repaint();
    }
    
    
    @Override
    public void repaint() {
    	//re-draw everything that will stay on screen
//	    currentLevel.drawLevel(terminal);
	    //Player.drawCreature();
    	super.repaint();
    }
    


	public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Roguelike");
    }

}