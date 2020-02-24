import java.awt.Color;

import processing.core.PApplet;

public class Dot {
	PApplet processing;
	Color color;
	float x;
	float y;
	float size;
	float value;

	Dot(PApplet processing, float x, float y, float size, float value, Color color) {
		this.processing = processing;
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		this.value = value;
	}

	public void draw() {

		processing.noStroke();
		processing.fill(color.getRed(), color.getGreen(), color.getBlue());
		processing.ellipseMode(processing.CENTER);
		processing.ellipse(x, y, size, size);
	}
}
