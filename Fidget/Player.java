import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

public class Player {
	PApplet processing;
	public float x, y;
	Color color;
	PImage img;
	public float rotation;
	public float speed = 1;

	Player(PApplet processing) {
		this.processing = processing;
		this.x = processing.width / 2;
		this.y = processing.height / 2;
		this.color = Color.cyan;
		img = processing.loadImage("fidget.png");
		rotation = 0;
		speed = .01f;

	}

	public void draw() {

		processing.pushMatrix();
		processing.imageMode(processing.CENTER);
		processing.translate(x, y);
		rotation+= speed;
		processing.rotate(rotation);
		img.resize((int) (100), (int) (100));
		processing.image(img, 0, 0);
		processing.popMatrix();
		processing.textAlign(processing.CENTER, processing.CENTER);
		processing.textSize(20);
		processing.text("ad04", x, y + 80);

	}

	public void move() {
		x = processing.lerp(x, processing.mouseX, .5f);
		y = processing.lerp(y, processing.mouseY, .5f);

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
