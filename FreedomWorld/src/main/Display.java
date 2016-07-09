package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JPanel;

import clientutils.Client;

public class Display extends JPanel{
	Player p;
	private static final long serialVersionUID = -2023725456998272858L;
	public static boolean forward;
	public static boolean backward;
	public static boolean left;
	public static boolean right;
	public Color[] colors = {Color.RED,Color.GREEN,Color.YELLOW,Color.BLUE,Color.BLACK,Color.MAGENTA,Color.CYAN};
	ConcurrentLinkedQueue<Player> players = new ConcurrentLinkedQueue<Player>();
	private Client c;
	public Display(String name, Client c){
		p = new Player(name,0,0,colors[(int) (Math.random()*colors.length)]);
		players.add(p);	
		this.c = c;
		setBackground(Color.decode("#00aa00"));
	}
	public void generatePlayers(){
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 5; x++){
				Player p = new Player("player0"+(x+1)*(y+1), x*100, y*200,colors[(int) (Math.random()*colors.length)]);
				players.add(p);
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
			if(forward){
				p.moveForward();
				
			}
			if(backward){
				p.moveBackward();
				c.sendObject("refresh "+this.p.getX()+","+this.p.getY()+" "+p.getName().trim());

			}
			if(left){
				p.moveLeft();
				c.sendObject("refresh "+this.p.getX()+","+this.p.getY()+" "+p.getName().trim());

			}
			if(right){
				p.moveRight();
				c.sendObject("refresh "+this.p.getX()+","+this.p.getY()+" "+p.getName().trim());

			}
		for(Player p : players){
			p.paint(g);
		}
		repaint();
	}


}
