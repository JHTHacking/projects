package main;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import clientutils.Client;
import clientutils.MessageHandler;

public class Ventana extends JFrame implements MessageHandler{

	private static final long serialVersionUID = 5532908151984083500L;
	Display d;
	public Ventana(final String name,String host){
		final Client c = new Client(host, 6000, this);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Game");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		d = new Display(name,c);
		d.setSize(getMaximumSize());
		d.setVisible(true);
		c.sendObject(d.p);
		Thread t = new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					c.sendObject("refresh "+d.p.getX()+","+d.p.getY()+" "+d.p.getName().trim());					
				
					c.sendObject("needPlayers "+name);
				}

			}
		});
		
		t.start();
		setContentPane(d);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W){
					d.forward = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					d.backward = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					d.left = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					d.right = false;
				}

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_W){
					d.forward = true;

				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					d.backward = true;

				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					d.left = true;

				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					d.right = true;

				}
				if(e.getKeyCode() == KeyEvent.VK_F5){
					//d.players.removeAll(d.players);
					//d.generatePlayers();
				}

			}
		});
	}
	@Override
	public void objectReceived(Object o) {
		System.out.println("I'm receiving...");
		if(o instanceof Player){
			boolean isAlreadyAdded = false;
			System.out.println("I received a object!");
			for(Player p2 : d.players){
				if(((Player) o).getName().equals(p2.getName())){
					isAlreadyAdded = true;

				}else{
					isAlreadyAdded = false;

				}
			}
			if(isAlreadyAdded){
				Player temp = (Player) o;
				for(Player p : d.players){
					if(temp.getName().equals(p.getName())){
						d.players.remove(p);
					}
				}

				d.players.add(temp);
			}else{
				d.players.add((Player) o);
				System.out.println("Player added!!");
			}
		}

	}
}
