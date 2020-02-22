import java.awt.Color;

import processing.core.PApplet;

public class Paddle {
	float x;
	float y;
	float width;
	float height;
	PApplet processing;
	Color color;

	Paddle(PApplet p, float x, float width, float height, Color color) {
		this.processing = p;
		this.x = x;
		this.y = 550;
		this.width = width;
		this.height = height;
		this.color = color;

	}

	public void update() {
		x = processing.mouseX;

	}

	public void display() {

		processing.strokeWeight(1);

		processing.stroke(color.getRed(), color.getGreen(), color.getBlue());
		processing.fill(color.getRed(), color.getGreen(), color.getBlue());
		processing.rectMode(processing.CENTER);
		processing.rect(x, y, width, height);

	}
	public boolean collide(Ball b){
		if (b.x + b.size/2 > x - width/2 && b.x - b.size/2 < x + width/2 && b.y + b.size/2 > y - height/2 && b.y - b.size/2 < y + height/2){
			return true;
			
		}
			return false;
	}

}
