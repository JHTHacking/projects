package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import serverutils.Listener;
import serverutils.MessageHandler;
import serverutils.Server;

public class GameServer implements MessageHandler{
	private Server s;
	public static void main(String args[]){
		new GameServer();
	}
	public GameServer() {
		s = new Server(6000, this);
	}
	ConcurrentLinkedQueue<Player> players = new ConcurrentLinkedQueue<Player>();
	@Override
	public void objectReceived(Object o, Listener l) {
		if(o instanceof Player){
			players.add((Player) o);
			return;
		}
		Object[] args = o.toString().split(" ");
		final String cmd = (String) args[0];
		if(cmd.equals("refresh")){
			if(args[1] != null && args[2] != null){
				String[] data = args[1].toString().split(",");
				int x = Integer.parseInt(data[0]);
				int y = Integer.parseInt(data[1]);
				for(Player p : players){
					if(p.getName().trim().equals(args[2].toString().trim())){
						Color last = p.getColor();
						String name = p.getName();
						DesignPart[][] parts = p.playerDesign;
						players.remove(p);
						System.out.println("Updating "+name.trim());
						Player tmp = new Player(name,x,y,last);
						tmp.playerDesign = parts;
						players.add(tmp);
					}
				}
				System.out.println("X: "+x+", Y: "+y);
			}
		}
		if(cmd.equals("needPlayers")){
			if(args[1] != null){
				for(Player p : players){
					if(!p.getName().equals(args[1])){
						l.sendObject(l.s, p);
					}
				}
			}
		}
	}

}
