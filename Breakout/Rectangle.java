import java.awt.Color;

import processing.core.PApplet;

public class Rectangle {
	
	PApplet processing;
	float width; 
	float height;
	float x;
	float y;
	Color innerColor;
	Color outerColor;
	
	
	
	
Rectangle(PApplet p, float x, float y,
			float width, float height, 
			Color iColor, Color oColor){
		
	processing = p; this.x = x; this.y = y; this.width = width;
	this.height = height; this.innerColor = iColor; this.outerColor = oColor;
	
		
	}
	
public void display(){
	processing.strokeWeight(1);
	
	processing.stroke(outerColor.getRed(), 
			outerColor.getGreen(),
			outerColor.getBlue());
	
	processing.fill(innerColor.getRed(), 
			innerColor.getGreen(),
			innerColor.getBlue());
	
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

