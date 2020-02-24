import java.awt.Color;

import processing.core.PApplet;

public class Virus {
	PApplet processing;
	public float x, y, size;
	Color color;
	public float rotation;
	
	Virus(PApplet processing, float x, float y, float size, Color color){
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		this.processing = processing;
		this.rotation = 0;
	}
	
	
	public void draw(){
		processing.pushMatrix();
		processing.noStroke();
		processing.rectMode(processing.CENTER);
		processing.translate(x, y);
		rotation += .2f;
		if(rotation > processing.PI*2){
			processing.rotate(rotation);
			
			processing.rectMode(processing.CENTER);
			processing.fill(color.getRed(), color.getGreen(), color.getBlue());
			processing.rect(0, 0, size, size);
		}
		processing.popMatrix();
	}
}

