import processing.core.PApplet;
import processing.core.PImage;

public class Letterloon {
	PApplet processing;
	float x, y, speed;
	PImage img;

	Letterloon(PApplet processing, float x, float y) {
		this.processing = processing;
		this.x = processing.random(processing.width);
		this.y = processing.random(processing.height);
		this.speed = processing.random((float) 0.1, 1);
		img = processing.loadImage("hbd.png");
	}

	public void draw() {
		processing.pushMatrix();
		processing.imageMode(processing.CENTER);
		processing.translate(x, y);
		img.resize(2089 / 10, 1779 / 10);
		processing.image(img, 0, 0);
		processing.popMatrix();
	}

	public void move() {
		y = y + 2;
		if (y > processing.height + 100) {
			y = -100;
			x = processing.random(processing.width);
		}
	}

}
