import java.awt.Color;

import processing.core.PApplet;

public class Ball {
	PApplet processing;
	float size;
	public float x;
	public float y;
	public float velocityX;
	public float velocityY;
	Color color;
	public float speed = 5;

	Ball(PApplet p, float x, float y, float size, Color color, int speedMod) {
		processing = p;
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		this.velocityX = speed + speedMod;
		this.velocityY = speed + speedMod;
	}

	public void display() {
		processing.strokeWeight(1);
		
		processing.stroke(color.getRed(), color.getGreen(), color.getBlue());
		processing.fill(color.getRed(), color.getGreen(), color.getBlue());
		processing.ellipseMode(processing.CENTER);
		processing.ellipse(x, y, size, size);
	}

	public void update() {
		x += velocityX;
		y += velocityY;
		if (x < 0 || x > processing.width) {
			flipX();
		}
		if (y < 0 || y > processing.height) {
			flipY();
		}

	}

	public void flipX() {
		velocityX *= -1;
	}

	public void flipY() {
		velocityY *= -1;
	}
	
	

}
