package main;

import java.awt.Color;
import java.io.Serializable;

public class DesignPart implements Serializable{
	private static final long serialVersionUID = -1450933731113051155L;
	private int x;
	private int y;
	private Color color;
	public DesignPart(int x, int y, Color color){
		this.color = color;
		this.x = x;
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

}
