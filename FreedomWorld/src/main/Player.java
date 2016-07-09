package main;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Player implements Serializable{


	private static final long serialVersionUID = 1L;
	DesignPart[][] playerDesign;
	private int y;
	private int x;
	private Object lastDirection;
	private String name;
	public Player(String name,int x, int y, Color color){
		this.setX(x);
		this.setY(y);
		this.setColor(color);
		this.setName(name);
		DesignPart o = new DesignPart(0,0,Color.ORANGE);
		DesignPart g = new DesignPart(0,0,color);
		DesignPart w = new DesignPart(0,0,Color.WHITE);
		DesignPart b = new DesignPart(0,0,Color.BLACK);
		DesignPart n = new DesignPart(0,0,Color.decode("#002200"));
		lastDirection = "right";
		playerDesign = new DesignPart[][]{
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,w,b,o,o,o,w,b,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{o,o,o,o,o,o,o,o,o,o,o},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g,g,g,g,g,g,o},
			{g,w,g,w,g,w,g,w,g,w,g,w,w,w,w,w,o},
			{g,w,g,w,g,w,g,w,g,w,g,g,g,g,g,g,g,o},
			{g,w,g,w,g,w,g,w,g,w,g,w,w,w,w,w,w,o},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g},
			{g,w,g,w,g,w,g,w,g,w,g},
			{n,n,o,o,n,n,n,o,o,n,n},
			{n,n,o,o,n,n,n,o,o,n,n},
			{n,n,o,o,n,n,n,o,o,n,n},	
			{n,n,o,o,n,n,n,o,o,n,n},			
			{n,n,o,o,n,n,n,o,o,n,n},			
			{n,n,o,o,n,n,n,o,o,n,n},			
			{n,n,o,o,n,n,n,o,o,n,n},			
			{n,n,o,o,n,n,n,o,o,n,n},			
			{n,n,b,b,n,n,n,b,b,n,n}

		};

	}
	int count = 0;
	private Color color;
	public void paint(Graphics g){
		count++;
		for(int i = 0; i < playerDesign.length; i++){
			for(int j = 0; j < playerDesign[i].length; j++){
				if(!(playerDesign[i][j].getColor() == Color.CYAN)){
					g.setColor(playerDesign[i][j].getColor());
					if(lastDirection.equals("left")){
						g.fillRect(j*5-35+getX(), i*5+getY(), 5, 5);
					}else{
						g.fillRect(j*5+getX(), i*5+getY(), 5, 5);

					}


				}



			}
		}
		g.setColor(Color.BLACK);
		if(getName().length() > 12){
			g.drawString(getName(), getX()-(getName().length()/2)*4, getY()-20);

		}else{
			g.drawString(getName(), getX(), getY()-20);

		}
	}
	public void moveForward() {
		DesignPart o = new DesignPart(0,0,Color.ORANGE);
		DesignPart g = new DesignPart(0,0,getColor());
		DesignPart w = new DesignPart(0,0,Color.WHITE);
		DesignPart b = new DesignPart(0,0,Color.BLACK);
		DesignPart n = new DesignPart(0,0,Color.CYAN);
		if((count/10) >= 2){
			playerDesign = new DesignPart[][]{
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g,},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,b,b,n,n},			
				{n,n,o,o,n,n,n,n,n,n,n},			
				{n,n,b,b,n,n,n,n,n,n,n}

			};
			if(count/10 >= 5){
				count = 0;
			}
		}else{
			playerDesign = new DesignPart[][]{
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g,},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,b,b,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,b,b,n,n}

			};
		}

		lastDirection = "forward";
		setY(getY() - 1);
	}
	public void moveBackward() {
		DesignPart o = new DesignPart(0,0,Color.ORANGE);
		DesignPart g = new DesignPart(0,0,getColor());
		DesignPart w = new DesignPart(0,0,Color.WHITE);
		DesignPart b = new DesignPart(0,0,Color.BLACK);
		DesignPart n = new DesignPart(0,0,Color.CYAN);
		if((count/10) >= 2){
			playerDesign = new DesignPart[][]{
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,w,b,o,o,o,b,w,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g,},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,o,o,g,w,g,o,o,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,b,b,n,n},			
				{n,n,o,o,n,n,n,n,n,n,n},			
				{n,n,b,b,n,n,n,n,n,n,n}

			};
			if(count/10 >= 5){
				count = 0;
			}
		}else{
			playerDesign = new DesignPart[][]{
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,w,b,o,o,o,b,w,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g,},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,o,o,g,w,g,o,o,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,b,b,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,b,b,n,n}

			};
		}


		lastDirection = "backward";
		setY(getY() + 1);
	}
	public void moveLeft() {
		DesignPart o = new DesignPart(0,0,Color.ORANGE);
		DesignPart g = new DesignPart(0,0,getColor());
		DesignPart w = new DesignPart(0,0,Color.WHITE);
		DesignPart b = new DesignPart(0,0,Color.BLACK);
		DesignPart n = new DesignPart(0,0,Color.CYAN);
		if((count/10) >= 2){
			playerDesign = new DesignPart[][]{
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,b,w,o,o,o,b,w,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,o,g,g,g,g,g,g,w,g,w,g,w,g,w,g,w,g},
				{n,o,w,w,w,w,w,g,w,g,w,g,w,g,w,g,w,g},
				{o,g,g,g,g,g,g,g,w,g,w,g,w,g,w,g,w,g},
				{o,w,w,w,w,w,w,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,b,b,n,n},			
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,n,n,n,n},			
				{n,n,n,n,n,n,n,n,n,b,b,n,n,n,n,n,n,n}

			};
			if(count/10 >= 5){
				count = 0;
			}
		}else{
			playerDesign = new DesignPart[][]{
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,b,w,o,o,o,b,w,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,o,o,o,o,o,o,o,o,o,o,o},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,o,g,g,g,g,g,g,w,g,w,g,w,g,w,g,w,g},
				{n,o,w,w,w,w,w,g,w,g,w,g,w,g,w,g,w,g},
				{o,g,g,g,g,g,g,g,w,g,w,g,w,g,w,g,w,g},
				{o,w,w,w,w,w,w,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,g,w,g,w,g,w,g,w,g,w,g},
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,b,b,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,n,n,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,n,n,n,n,n,n,n,b,b,n,n}

			};
		}

		setX(getX() - 1);
		lastDirection = "left";
	}
	public void moveRight() {
		DesignPart o = new DesignPart(0,0,Color.ORANGE);
		DesignPart g = new DesignPart(0,0,getColor());
		DesignPart w = new DesignPart(0,0,Color.WHITE);
		DesignPart b = new DesignPart(0,0,Color.BLACK);
		DesignPart n = new DesignPart(0,0,Color.CYAN);
		if(count/10 >= 2){
			playerDesign = new DesignPart[][]{
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,w,b,o,o,o,w,b,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g,g,g,g,g,g,o},
				{g,w,g,w,g,w,g,w,g,w,g,w,w,w,w,w,o},
				{g,w,g,w,g,w,g,w,g,w,g,g,g,g,g,g,g,o},
				{g,w,g,w,g,w,g,w,g,w,g,w,w,w,w,w,w,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,b,b,n,n},			
				{n,n,o,o,n,n,n,n,n,n,n},			
				{n,n,b,b,n,n,n,n,n,n,n}

			};
			if(count/10 >= 5){
				count = 0;
			}
		}else{
			playerDesign = new DesignPart[][]{
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,w,b,o,o,o,w,b,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{o,o,o,o,o,o,o,o,o,o,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g,g,g,g,g,g,o},
				{g,w,g,w,g,w,g,w,g,w,g,w,w,w,w,w,o},
				{g,w,g,w,g,w,g,w,g,w,g,g,g,g,g,g,g,o},
				{g,w,g,w,g,w,g,w,g,w,g,w,w,w,w,w,w,o},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{g,w,g,w,g,w,g,w,g,w,g},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},
				{n,n,o,o,n,n,n,o,o,n,n},	
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,o,o,n,n,n,o,o,n,n},			
				{n,n,b,b,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,o,o,n,n},			
				{n,n,n,n,n,n,n,b,b,n,n}

			};
		}

		setX(getX() + 1);
		lastDirection = "right";

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
