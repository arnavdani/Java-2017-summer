import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {
	PApplet processing;
	public float x, y;
	PImage img;
	public float rotation;
	public float speed, velocityX, velocityY;

	Enemy(PApplet processing) {
		this.processing = processing;
		this.x = processing.random(processing.width);
		this.y = processing.random(processing.height);
		img = processing.loadImage("fidget.png");
		rotation = 0;
		speed = .01f;
		velocityX = processing.random(-5, 5);
		velocityY = processing.random(-5, -5);
	}

	public void draw() {

		processing.pushMatrix();
		processing.imageMode(processing.CENTER);
		processing.translate(x, y);
		rotation += speed;
		processing.rotate(rotation);
		img.resize( 100, 100);
		processing.image(img, 0, 0);
		processing.popMatrix();
		processing.textAlign(processing.CENTER, processing.CENTER);
		processing.textSize(20);
		processing.text("Enemy", x, y + 80);

	}

	public void move() {
		x += velocityX;
		y += velocityY;
		if (x > processing.width || x < 0) {
			velocityX *= -1;

		}
		if (y > processing.height || y < 0) {

			velocityY *= -1;
		}

	}

	public void speedUp(float amt) {

		speed += amt;
		speed += 1;

	}

	public void speedDown(float amt) {

		speed -= 20;
		if (speed < 0) {
			speed = 0;

		}
	}
}